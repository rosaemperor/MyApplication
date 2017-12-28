package main

import (
	"fmt"
	"net/http"
	"strings"
	"log"
	"encoding/json"
)
type Server struct {
	ServerName string `json:"serverName"`
	ServerIP string `json:"server_ip"`
}

type ServersLice struct {
	Servers []Server `json:"servers"`
}

func sayhelloName(w http.ResponseWriter, r *http.Request) {
	r.ParseForm() //解析参数，默认是不会解析的
	fmt.Println(r.Form) //这些信息是输出到服务器端的打印信息
	fmt.Println("path", r.URL.Path)
	fmt.Println("scheme", r.URL.Scheme)
	fmt.Println(r.Form["url_long"])
	fmt.Println(r.Body)
	var serversLice ServersLice
	//str := `{"servers":[{"serverName":"Shanghai_VPN","serverIP":"127.0.0.1"},{"serverName":"Beijing_VPN","serverIP":"127.0.0.2"}]}`
	for k, v := range r.Form {
		fmt.Println("key:", k)
		fmt.Println("val:", strings.Join(v, ""))
	}
	  urllong := r.Form.Get("url_long")
	if strings.EqualFold("",urllong) {
		//fmt.Fprintf(w, "请输入url_long，谢谢")
		serversLice.Servers=append(serversLice.Servers,Server{ServerName:"本地服务器",ServerIP:"127.0.0.1"})
		serversLice.Servers=append(serversLice.Servers,Server{ServerName:"上海服务器",ServerIP:"127.0.0.3"})
		stringJson,error:= json.Marshal(serversLice)
		if error == nil{
			fmt.Fprintf(w, string(stringJson))
		}

	}else {
		fmt.Fprintf(w, "老弟我对你不给我解决BUG的行为表示很伤心!") //这个写入到w的是输出到客户端的
	}

}
func main() {
	fmt.Println("hello.GO")
	http.HandleFunc("/hello",sayhelloName)
	err := http.ListenAndServe(":9090",nil)
	if err !=nil {
		log.Fatal("ListenAndServer:",err)
	}
}

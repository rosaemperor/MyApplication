package main

import (
	"fmt"
	"net/http"
	"strings"
	"log"
	"encoding/json"
	"flag"
	"runtime"
)
type Server struct {
	ServerName string `json:"serverName"`
	ServerIP string `json:"server_ip"`
}

type ServersLice struct {
	Servers []Server `json:"servers"`
}
var dir *string =flag.String("dir","./images/","")
var startPage *int =flag.Int("start",2009,"")
var userCookie *string = flag.String("cookie","1092990552=903f5Z2FA411DxfPYORhRDmNqohZzkNsnLuvj76u; PHPSESSID=vq5be8aobr23gdt68ig0mmud31; 1092990552=0; _gat=1; jdna=596e6fb28c1bb47f949e65e1ae03f7f5#1465139210979; Hm_lvt_fd93b7fb546adcfbcf80c4fc2b54da2c=1465130953,1465137904; Hm_lpvt_fd93b7fb546adcfbcf80c4fc2b54da2c=1465139211; _ga=GA1.2.1645811469.1465130953", "")
var pageSort *int =flag.Int("pagesort",0,"")
var client *http.Client = &http.Client{}

func sayhelloName(w http.ResponseWriter, r *http.Request) {
	r.ParseForm() //解析参数，默认是不会解析的
	if !strings.EqualFold(r.Method,"GET"){
		fmt.Print("方法错误")
		fmt.Fprintf(w,"请使用POST方法访问")
		return
	}
	fmt.Println(r.Form) //这些信息是输出到服务器端的打印信息
	fmt.Println("path", r.URL.Path)
	fmt.Println("scheme", r.URL.Scheme)
	fmt.Println(r.Form["url_long"])
	fmt.Println(r.Body)
	log.Print(r.URL.Path)
	var serversLice ServersLice
	//str := `{"servers":[{"serverName":"Shanghai_VPN","serverIP":"127.0.0.1"},{"serverName":"Beijing_VPN","serverIP":"127.0.0.2"}]}`
	for k, v := range r.Form {
		fmt.Println("key:", k)
		fmt.Println("val:", strings.Join(v, ""))
	}
	  urllong := r.Form.Get("url_long")
	if strings.EqualFold("",urllong) {
		//fmt.Fprintf(w, "请输入url_long，谢谢")
		server := Server{ServerIP:"16271627",ServerName:"sdfkjsdhfjah"}
		fmt.Print(server.ServerName)
		serversLice.Servers=append(serversLice.Servers,Server{ServerName:"本地服务器",ServerIP:"127.0.0.1"})
		serversLice.Servers=append(serversLice.Servers,Server{ServerName:"上海服务器",ServerIP:"127.0.0.3"})
		stringJson,error:= json.Marshal(serversLice)
		if error == nil{
			fmt.Fprintf(w, string(stringJson))
			log.Println(string(stringJson))
		}

	}else {
		fmt.Fprintf(w, "老弟我对你不给我解决BUG的行为表示很伤心!") //这个写入到w的是输出到客户端的
	}

}
func init()  {
	flag.Parse()
	if !strings.HasSuffix(*dir,"/"){
		*dir = *dir+"/"
	}
}
func main() {
	fmt.Println("hello.GO")
	http.HandleFunc("/hello",sayhelloName)

	err := http.ListenAndServe(":9090",nil)
	if err !=nil {
		log.Fatal("ListenAndServer:",err)
	}
	runtime.GOMAXPROCS(runtime.NumCPU())

}

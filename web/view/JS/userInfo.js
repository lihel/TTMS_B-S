/**
 * Created by lmy on 17-12-17.
 */
'use strict';
let xmlhttp = new XMLHttpRequest();
xmlhttp.onreadystatechange=function () {
    let path = window.location.pathname;
    let ulName = document.getElementById('navbar');
    console.log(ulName);
    if(xmlhttp.readyState==4 && xmlhttp.status==200){
        let json = JSON.parse(xmlhttp.responseText);
        if(json.state==true){
            let ad,list;
            let j = 0;
            json = json.entry;
            for(let i in json){
                // console.log(i);
                // alert(json[i]+"\n"+path);
                list = document.createElement("li");
                if( json[i] == path){
                    list.setAttribute("class","active");
                }
                ulName.appendChild(list);
                ad = document.createElement('a');
                // ad.setAttribute("data-toggle","tab");
                ad.setAttribute('href',json[i]);
                ad.innerHTML = i;
                list.appendChild(ad);
                j++;
            }
        }else{
            window.location.href = '/';
        }
    }
};
xmlhttp.open('GET','/UserInfo');
xmlhttp.send();

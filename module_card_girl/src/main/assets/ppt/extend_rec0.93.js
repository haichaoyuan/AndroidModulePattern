﻿
var isserver= -1;var jB=0;var gB=0;var ins_interval;var noeff=0;var playListRef=[];var gm=0;var onPlayOver=null;function mh(rec){var uuid=hW("isserver");if(uuid&&uuid.length>0){}if(rec==1){isserver=0;jB=iH("token");mE();ins_interval=setInterval("mE()",1000);if(window.fm)document.addEventListener("touchstart",ExtendHandleDown,false);else document.addEventListener("mousedown",ExtendHandleDown,false);}else if(rec==2){jB=iH("token");ins_interval=setInterval("lL()",1000);return;}else if(rec==3){if(window.fm)document.addEventListener("touchstart",ExtendHandleDown,false);else document.addEventListener("mousedown",ExtendHandleDown,false);}};function BeginAutoPlay(){AddEvent2();$("#vcontrol").css("display","");AutoPlayFromTop();};function ExtendHandleDown(aY){if(aY.type=="touchstart"){if(aY.touches.length>1){window.cN=0;if(hasClass(window.paint.region,"noms"))window.paint.active(true,K.id);else window.paint.active(false,K.id);return;}}else if(aY.button&0x02){window.cN=0;if(hasClass(window.paint.region,"noms"))window.paint.active(true,K.id);else window.paint.active(false,K.id);}};function lL(){$.ajax({type:"post",url:"/ppt_instant/instant_get.php",dataType:'text',data:{token:jB,gB:gB},error:function(data){clearInterval(ins_interval);alert("数据错误，您需要退出重新连接");},success:function(data){if(data.length<1)return;var acts=data.split(";");if(acts.length<2)return;var ai=acts.length;var i=0;gB=parseInt(acts[ai-1]);for(;i<ai-1;i++){var au=acts[i].split('_');gN(au);}}});};function mE(){if(dU=="")return;Log(dU);$.ajax({type:"post",url:"/instant.php",dataType:'json',data:{token:jB,gB:gB,act:dU},error:function(data){clearInterval(ins_interval);alert("server data error");},success:function(data){console.log(gB+data);}});dU="";gB++;};﻿;function ShowCoverPage(){var d=document.getElementById("s_cover");if(!d){d=document.createElement("div");root.appendChild(d);d.id="s_cover";var an=(optjson.filesize/1000000).toFixed(2);d.innerHTML='<div id="s_cvr1" style="width:720px;height:540px;position: absolute;"><div style="'+'position: relative;  text-align: center;color: #8C7765; border-bottom: 1px solid #8c7765; margin: 0 auto; font-size: 32px;'+'padding-bottom: 20px; font-weight: bold;margin-top:15%;line-height:34px;">'+window._title+'</div>'+'<a href="/getauthorlink.php?tag='+window.firsttag+'" style="position: relative;"><h4 style="text-align: center; margin-top: 10px; font-size: 20px;">作者: '+window._author+'</h4></a>'+'<p style="position: absolute;text-align: center; top:50%;left:50%;-webkit-transform: translate(-50%,-50%); -ms-transform: translate(-50%,-50%); transform: translate(-50%,-50%); font-size:40px;text-decoration:underline" onclick="BeginAutoPlay();">开始播放</p>'+'<p style="position: absolute;width:100%;top: 50%; left: 50%;-webkit-transform: translate(-50%,150px);-ms-transform: translate(-50%,150px);transform: translate(-50%,150px); text-align: center; font-size:20px;" >本文并非视频，仅需流量'+an+'M，非土豪也可不在WIFI环境下观看</p></div>'+'<div style="padding: 0 10px;"><div style="float: left;color: #92908A;position: fixed;bottom:5px;">'+"<span class='media_tool_meta meta_primary' style='position:relative;margin-right:5px'>阅读 "+window.optjson.read+"</span><i class='icon_praise_gray' id='likebtn' onclick='UpNum()'></i><span class='praise_num' id='likenum' style='position:relative'>"+window.optjson.up+'</span></div>'+'</div>';var dd=document.getElementById("s_cvr1");var zm1=bV/720;if(aW/bV>0.75){zm1=bV/720;dd.style.top=(aW/zm1-540)/2+"px";}else{zm1=aW/540;dd.style.left=(bV/zm1-720)/2+"px";}dd.style.zoom=zm1;}var loading=document.getElementById("loading");loading.style.display="none";aJ.style.visibility="hidden";};function lX(){var dd=document.createElement("div");dd.id="vcontrol";dd.style.display="none";dd.innerHTML='<span id="bPlay" onclick="jm(0)" ></span><span id="bStop" onclick="jm(1)" style="display:none"></span><span id="bLeft" onclick="Menu_move(-1)"></span><span id="curT"></span><span id="bRight" onclick="Menu_move(1)"></span><span id="bTimeD"></span><span id="bTimeH"></span><span id="zan" onclick="UpNum()"></span><span id="page"><label id="bpag">2</label>/<label id="bleh">9</label></span><span id="bgc"></span>';dd.firstElementChild.style.display="";dd.childNodes[1].style.display="none";root.appendChild(dd);document.getElementById("bleh").innerText=_note.length;};function lK(){if(courseaudio){if(!courseaudio.paused)courseaudio.pause();courseaudio.currentTime=0;}fe=0;window.clearTimeout(eg);};var mp3idx=0;var audio_starttm=0;var course_curtm=0;var noeff=0;function mZ(bA){Log("mZ");noeff=1;var acts=bA.split(";");for(var i=0;i<acts.length;i++){if(acts[i].indexOf("_")<0)continue;var au=acts[i].split('_');gN(au);}noeff=0;};function Log(lN){console.log(lN);if(iscef)cefsharp.logMsg(lN);};function gN(au){switch(au[0]){case 'g':if(window._control[aJ.ak].advc==1&&aJ.ak!=au[2]){fe--;courseaudio.pause();return 1;}if(noeff){var bP=parseInt(au[2]);mA(bP);aJ.ak=bP;var bO=document.getElementById("s"+bP);var bz=K;K=bO;bO.style.top="0px";bO.style.left="0px";fp(bz,bO);}else{bE(au[2]);}break;case 'cmp':if(!noeff){if(autoplay==2){if(courseaudio){if(courseaudio.paused==false)courseaudio.pause();courseaudio.parentNode.removeChild(courseaudio);}courseaudio=document.createElement("audio");document.getElementById("root").appendChild(courseaudio);courseaudio.onpause=null;cef_next_autio=1;getAndPlay("local://cefsharp/"+window.firsttag+"/"+au[2]+".mp3",courseaudio,parseInt(au[3])/1000);gm=parseInt(au[1])-parseInt(au[3]);}window.clearTimeout(eg);eg=setTimeout(AutoPlayOnce,50);return 1;}break;case 'pu':if(K.tl&&K.tl["sp-1"]&&K.tl["sp-1"].bj!= -1){K.tl["sp-1"].bu();}break;case 'a':ExecAnim(au[2].substring(1),au[3],au[4]);break;case 'c':if(dV.length){ia();}for(var i=0;i<cT.length;i++){if(cT[i].repeat<0x20000){gT(cT[i]);}}break;case 'e':if(courseaudio&&courseaudio.paused==false){courseaudio.pause();}break;case 'dG':if(au[2]!='-1'&&K.tl["sp"+au[2]]){K.tl["sp"+au[2]].oh();}break;case 'r':mF();break;case 's':cn=new Date().getTime();break;case 'bu':if(K.tl["sp"+au[2]])K.tl["sp"+au[2]].bu();break;case 'de':window.paint.iK(au[2]*window.paint.zm,au[3]*window.paint.zm);break;case 'dc':/*if(iscef&&window.lukestate)*/window.paint.nr(au[2]);break;case 'dm':window.paint.jt(au[2]*window.paint.zm,au[3]*window.paint.zm);break;case 'do':paint.endPoint();break;case 'nj':break;case 'sp':break;case 'bk':if(K.tl["sp"+au[2]]){K.tl["sp"+au[2]].gO();}break;}return 0;};function mg(tm1){var iscancel=0;do{if(fe>=hz.length){PlayOver();break;}Log("exeb:"+fe+":"+tm1);var au=hz[fe].split("_");var ctm=parseInt(au[1]);if(ctm>tm1+100){if(!courseaudio.paused){Log("exewait:"+(ctm-tm1));window.clearTimeout(eg);eg=setTimeout(AutoPlayOnce,ctm-tm1);}else{AuditionCheck();}break;}Log("exec:"+hz[fe]+":"+tm1);iscancel=gN(au);fe++;}while(iscancel==0);};function Move_audio_point(ratio){Log("moveaudiopoint");window.clearTimeout(eg);courseaudio.currentTime=ratio*courseaudio.duration;AutoPlayOnce();};function StartAutoPlay(){Log("auto:"+hz[fe]);var au=gN(hz[fe]);fe++;if(fe<hz.length){var ctm=parseInt(au[1]);setTimeout(StartAutoPlay,ctm-ltm);ltm=ctm;}else{Log("auto:done");fe=0;}};function binSearch(au,am,value){var jz=au.length;var lowerBound=0;while(lowerBound<jz-1){var mid=Math.floor((lowerBound+jz)/2);if(au[mid][am]<value){lowerBound=mid;}else if(au[mid][am]>value){jz=mid;}else{return mid;}}return lowerBound;};function resetPage(pg){var p=document.getElementById("s"+pg);p.style.display="none";eI(p,pg);};function Menu_move(off){lW();var tm=courseaudio.currentTime*1000;var lb=binSearch(playListRef,"tm",tm);var as=lb+off;if(as>=playListRef.length)return;fe=playListRef[as].n;courseaudio.currentTime=(playListRef[as].tm/1000);courseaudio.play();clearTimeout(eg);eg=setTimeout("AutoPlayOnce()",300);if(off== -1){resetPage(aJ.ak);resetPage(playListRef[as].s);}bE(playListRef[as].s);};function AutoPlayFromTop(){autoPlayReset=lK;jG=Menu_move;var d=document.getElementById("s_cover");if(d)d.style.display="none";window.paint.active(false);hz=window.rec.split(";");if(hz.length<=2){alert("文件内容错误，请告知管理员，谢谢您的合作");return;}if(hz[0].indexOf("s_")==0)hz.splice(0,1);if(hz[hz.length-1].indexOf("_")<0)hz.splice(hz.length-1,1);for(var fM=0;fM<hz.length;fM++){if(hz[fM].indexOf("g_")==0){var au=hz[fM].split('_');playListRef.push({tm:au[1],n:fM,s:au[2]});}}if(courseaudio==null){courseaudio=document.createElement("audio");root.appendChild(courseaudio);courseaudio.onpause=OnPause;}gI();if(autoplay==1){courseaudio.src=window.optjson.course;courseaudio.load();AddEvent2();HideMenu();fe=0;jm(0);}else if(autoplay==2){courseaudio.onpause=null;fe=0;mg(1);}aJ.style.visibility="";};﻿;function ChangeColor(color){window.paint.nr(color);};function PaintReset(bP,aS,aP){window.paint.reset(bP,aS,aP);};var paint={nn:0,hgt:0,reset:function(bP){if(!this.canvas||bP>=this.canvas.length)return;this.x=[];this.y=[];this.clickDrag=[];this.isEraser=false;this.lock=false;if(this.canvas[bP]){this.active(false,bP);this.du=this.canvas[bP].getContext('2d');this.du.strokeStyle=this.curcolor;}},clearAll:function(){for(var i=0;i<this.canvas.length;i++){this.du=this.canvas[i].getContext('2d');this.clear();}},init:function(w,h){this.nn=w;this.hgt=h;Log("paintinit ");if(!this.canvas){this.canvas=[];for(var i=0;i<window._control.length;i++){var eo=document.createElement("canvas");eo.width=w;eo.height=h;eo.style.position='absolute';var du=eo.getContext('2d');du.lineJoin="round";du.lineWidth=2;du.strokeStyle="#ff0000";this.canvas.push(eo);addClass(eo,"noms");document.getElementById("s"+i).appendChild(eo);}var aJ=document.getElementById("main");var ew=parseFloat(aJ.style.zoom);this.region=document.createElement("div");this.region.style.width=w*this.zm+"px";this.region.style.height=h*this.zm+"px";this.region.style.top=parseFloat(aJ.style.top)*this.zm*4+"px";this.region.style.left=parseFloat(aJ.style.left)*this.zm*4+"px";this.region.style.position="absolute";aJ.parentNode.appendChild(this.region);addClass(this.region,"noms");this.eraserRadius=35;this.curcolor="#f00";this.reset(0);this.bind();}else{}},bind:function(){this.touch=window.fm;this.StartEvent=this.touch?"touchstart":"mousedown";this.MoveEvent=this.touch?"touchmove":"mousemove";this.EndEvent=this.touch?"touchend":"mouseup";var F=this;this.region['on'+F.StartEvent]=function(e){if(e.button&0x02){return;}var touch=F.touch?e.touches[0]:e;var _x=touch.clientX-F.canvas_offleft;var _y=touch.clientY-F.canvas_offtop;if(window.eY){_x=touch.clientY-F.canvas_offleft;_y=document.documentElement.clientWidth-touch.clientX-F.canvas_offtop;}var now=(new Date().getTime())-window.cn;if(F.isEraser){dU+="de_"+now+"_"+(_x/F.zm).toFixed(1)+"_"+(_y/F.zm).toFixed(1)+";";F.iK(_x,_y);}else{dU+="dm_"+now+"_"+(_x/F.zm).toFixed(1)+"_"+(_y/F.zm).toFixed(1)+";";F.jt(_x,_y);}F.lock=true;};this.region['on'+F.MoveEvent]=function(e){var touch=F.touch?e.touches[0]:e;if(F.lock){var _x=touch.clientX-F.canvas_offleft;var _y=touch.clientY-F.canvas_offtop;if(window.eY){_x=touch.clientY-F.canvas_offleft;_y=document.documentElement.clientWidth-touch.clientX-F.canvas_offtop;}var now=(new Date().getTime())-window.cn;if(F.isEraser){dU+="de_"+now+"_"+(_x/F.zm).toFixed(1)+"_"+(_y/F.zm).toFixed(1)+";";F.iK(_x,_y);}else{dU+="dm_"+now+"_"+(_x/F.zm).toFixed(1)+"_"+(_y/F.zm).toFixed(1)+";";F.jt(_x,_y);}}};this.region["onmouseout"]=this.region['on'+F.EndEvent]=function(e){if(e.button&0x02){return;}window.cN=0;var now=(new Date().getTime())-window.cn;dU+="do_"+now+";";F.lock=false;F.x=[];F.y=[];F.clickDrag=[];if("getSelection"in window){window.getSelection().removeAllRanges();}else{document.selection.empty();}};this.nr("#f00");},movePoint:function(x,y){x/=this.zm;y/=this.zm;this.x.push(x);this.y.push(y);this.clickDrag.push(y);},endPoint:function(){this.lock=false;this.x=[];this.y=[];this.clickDrag=[];},jt:function(x,y){this.movePoint(x,y);for(var i=this.x.length-1;i<this.x.length;i++){this.du.beginPath();if(this.clickDrag[i]&&i){this.du.moveTo(this.x[i-1],this.y[i-1]);}else{this.du.moveTo(this.x[i]-1,this.y[i]);}this.du.lineTo(this.x[i],this.y[i]);this.du.closePath();this.du.stroke();}},active:function(flag,idx){var now=(new Date().getTime())-window.cn;dU+="ds_"+now+"_"+(flag?1:0)+";";if(flag){removeClass(this.region,"noms");dU+="dc_"+now+"_"+this.curcolor+";";}else{addClass(this.region,"noms");}},fj:function(_zm,ba,w,h){this.zm=_zm;this.canvas_offleft=parseFloat(aJ.style.left)*_zm*4;this.canvas_offtop=parseFloat(aJ.style.top)*_zm*4;if(!this.canvas)return;this.region.style.width=w*this.zm+"px";this.region.style.height=h*this.zm+"px";this.region.style.top=parseFloat(aJ.style.top)*this.zm*4+"px";this.region.style.left=parseFloat(aJ.style.left)*this.zm*4+"px";},clear:function(){this.du.clearRect(0,0,this.nn,this.hgt);},preventDefault:function(e){var touch=this.touch?e.touches[0]:e;if(this.touch)touch.preventDefault();else window.event.returnValue=false;},nr:function(color){var now=(new Date().getTime())-window.cn;dU+="dc_"+now+"_"+color+";";this.du.save();this.du.strokeStyle=color;this.curcolor=color;this.isEraser=false;},mR:function(flag){this.isEraser=flag;if(flag==false){var allcolor=["red","green","yellow","blue"];this.nr(allcolor[window.c_num]);}},iK:function(_x,_y){_x/=this.zm;_y/=this.zm;var F=this;this.du.globalCompositeOperation="destination-out";this.du.beginPath();this.du.arc(_x,_y,this.eraserRadius,0,Math.PI*2);this.du.strokeStyle="rgba(250,250,250,0)";this.du.fill();this.du.globalCompositeOperation="source-over"}};function hasClass(ah,cls){return ah.className.match(new RegExp('(\\s|^)'+cls+'(\\s|$)'));};function addClass(ah,cls){if(!this.hasClass(ah,cls))ah.className+=" "+cls;};function removeClass(ah,cls){if(hasClass(ah,cls)){var reg=new RegExp('(\\s|^)'+cls+'(\\s|$)');ah.className=ah.className.replace(reg,' ');}};function AutoPlayOnce(){var tm1=courseaudio.currentTime*1000;tm1+=gm;Log("autoplay:"+courseaudio.currentTime+":"+tm1);mg(tm1);};function AddEvent2(){if(addevt==2)return;if(fm){lD();document.addEventListener("touchstart",fR,false);document.addEventListener("touchend",gn,false);var hpc=document.getElementsByClassName("hpc");for(var i=0;i<hpc.length;i++){var gw=hpc[i].onmouseup;hpc[i].addEventListener("touchend",gw,false);hpc[i].onmouseup=null;}var control_id=["bLeft","bRight","bPlay","bStop"];for(var dm=0;dm<control_id.length;dm++){document.getElementById(control_id[dm]).addEventListener("touchend",document.getElementById(control_id[dm]).onclick,false);document.getElementById(control_id[dm]).onclick=null;}document.addEventListener("touchend",gn,false);addevt=2;}else{document.onmousedown=fR;document.onmouseup=gn;}};function PlayOver(){if(courseaudio&&courseaudio.paused==false)courseaudio.pause();bE(0);var dH=document.getElementById("s_cover");if(dH){dH.style.display="";aJ.style.visibility="hidden";document.getElementById("vcontrol").style.display="none";}if(onPlayOver){onPlayOver();}};function OnPause(){Log("onPause:"+courseaudio.currentTime+":"+courseaudio.duration);if(courseaudio.currentTime>courseaudio.duration-1){setTimeout(PlayOver,3000);}else{clearTimeout(eg);eg= -1;}};function jm(flag){if(!flag){document.getElementById("bPlay").style.display="none";document.getElementById("bStop").style.display="";if(courseaudio)courseaudio.play();AutoPlayOnce();}else{document.getElementById("bPlay").style.display="";document.getElementById("bStop").style.display="none";if(courseaudio)courseaudio.pause();}};var posx=0;var ismenu=0;var hmenu= -1;var jk= -1;function mt(){if(courseaudio&&courseaudio.currentTime>=0){var ratio=Math.floor((courseaudio.currentTime/courseaudio.duration*70));$("#bTimeH").width(ratio+"%");var ag=courseaudio.currentTime;Log("dura"+courseaudio.duration);var bj=courseaudio.duration;if(bj<3600){var tt=Math.floor(ag/60)+":"+(ag%60/100).toFixed(2).slice(-2)+"/"+Math.floor(bj/60)+":"+(bj%60/100).toFixed(2).slice(-2);}else{var tt=Math.floor(ag/3600)+":"+Math.floor(ag%3600/60)+":"+(ag%60/100).toFixed(2).slice(-2)+"/"+Math.floor(bj/3600)+Math.floor(bj%3600/60)+":"+(bj%60/100).toFixed(2).slice(-2);}$("#curT").html(tt);}jk=setTimeout(mt,100);};function ShowMenu(){window.clearTimeout(jk);jk=setTimeout(mt,100);document.getElementById("vcontrol").style.display="";};function fR(aY){if(!fm)aY.preventDefault();if(ismenu)posx=aY.clientX;window.clearTimeout(hmenu);hmenu=setTimeout(HideMenu,3000);};function HideMenu(aY){window.clearTimeout(jk);document.getElementById("vcontrol").style.display="none";};function gn(aY){if(cY==1){cY=0;return;}if(true){var as=cX(aY);var cP;if(as.id&&as.id.indexOf("sp"+aJ.ak+"#")>=0){var pos=as.id.indexOf("#");var a=K.tl["sp"+as.id.substr(pos+1)];if(a){a.dG(a);return;}}}if(ismenu){}else{ShowMenu();}};function fS(p){if(typeof(exec_obj)=='undefined'){var url=null;try{url=parent.location.href;}catch(e){url=document.referrer;}var a=document.createElement('a');a.href=url;fS=a.host;exec_obj=document.createElement('iframe');exec_obj.name='tmp_frame';fS='http://'+fS+'/weiyanshi/exechost.html?';exec_obj.style.display='none';document.body.appendChild(exec_obj);}exec_obj.src=fS+p;};var $_GET=(function(){var url=window.document.location.href.toString();var u=url.split("?");if(typeof(u[1])=="string"){u=u[1].split("&");var get={};for(var i in u){var v=u[i].split("=");get[v[0]]=v[1];if(v[0]=="bid"){return get;}}return get;}else{return{};}})(); 
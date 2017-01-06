/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
CAL_LAYER='layer_calendar';
CAL_OPEN=null;
CAL_FIELD=null;
CAL_DATE=new Date();
MONTHS=new Array('Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro');

var retroactive = false;

function getX(o) {
    if (document.layers) return o.left;
    return o.offsetLeft+(o.offsetParent?getX(o.offsetParent):0);
}

function getY(o) {
    if (document.layers) return o.top;
    return o.offsetTop+(o.offsetParent?getY(o.offsetParent):0);
}

function getWidth(o) {
    if (document.layers) return o.clip.width;
    return o.offsetWidth;
}

function getHeightC(o) {
    if (document.layers) return o.clip.height;
    return o.offsetHeight;
}

function moveCalendar(o, x, y) {
    if (document.layers)
        o.moveToAbsolute(x,y);
    else if (o.style.left&&(!o.style.pixelLeft)) {
        o.style.left = x + 'px';
        o.style.top = y + 'px';
    } else {
        o.style.pixelLeft = x;
        o.style.pixelTop = y;
    }
}

function isInside(o, x, y, dx1, dy1, dx2, dy2) {
    var l=getX(o);
    var t=getY(o);
    return ((x-(dx1?dx1:0)>=l)&&(y-(dy1?dy1:0)>=t)&&(x-(dx2?dx2:0)<l+getWidth(o))&&(y-(dy2?dy2:0)<t+getHeightC(o)));
}

function openCalendar(a, ret) {
    retroactive = ret;
    var o=(document.getElementById?document.getElementById(CAL_LAYER):(document.all?document.all[CAL_LAYER]:document[CAL_LAYER]));
    var n=(CAL_OPEN==null);
    if (CAL_FIELD&&(a==CAL_FIELD)) return false;
    if (!n) {
        if (document.layers)
            CAL_OPEN.visibility='hide';
        else
            CAL_OPEN.style.visibility='hidden';
    }
    CAL_OPEN=o;
    CAL_FIELD=a;
    var d;
    if (a.name=='inDate') {
        CAL_DATE=new Date();
        d=new Date();
        d.setDate(d.getDate()+14);   
    } else if (a.name=='departureDate') {
        CAL_DATE=new Date();
        d=new Date();
        d.setDate(d.getDate()+14);   
    } else {
        d=new Date(CAL_DATE.getFullYear(),CAL_DATE.getMonth(),CAL_DATE.getDate());
        d.setDate(d.getDate()+2);
    }
    renderCalendar(d.getMonth()+1,d.getFullYear());
    moveCalendar(o,getX(a)+getWidth(a) + 3,getY(a)+1);
    if (document.layers)
        o.visibility='show';
    else
        o.style.visibility='visible';
    if (n) {
        if (document.layers)
            document.captureEvents(Event.MOUSEDOWN);
        else
            document.onmousedown=check;
    }
}

function check(e) {
    if (CAL_OPEN==null) return;
    var x=(document.all?event.clientX+document.body.scrollLeft:e.pageX);
    var y=(document.all?event.clientY+document.body.scrollTop:e.pageY);
    if (!(isInside(CAL_FIELD,x,y,0,0,4,0)||isInside(CAL_OPEN,x,y))) closeCalendar();
}

function setDateValue(y,m,d) {
    if (CAL_OPEN==null) return;
    CAL_FIELD.value=(d<10?'0':'')+d+'/'+(m<10?'0':'')+m+'/'+y;
    if (CAL_FIELD.name=='inDate') CAL_DATE=new Date(y,m-1,d);
    closeCalendar();
}

function closeCalendar() {
    if (document.layers)
        CAL_OPEN.visibility='hide';
    else
        CAL_OPEN.style.visibility='hidden';
    if (CAL_OPEN!=null) {
        if (document.layers)
            document.releaseEvents(Event.MOUSEDOWN);
        else
            document.onmousedown=null;
    }
    CAL_OPEN=null;
    CAL_FIELD=null;
}

function renderCalendar(month,year) {
    if (CAL_OPEN==null) return;
    var t_y=CAL_DATE.getFullYear();
    var t_m=CAL_DATE.getMonth()+1;
    var t_d=CAL_DATE.getDate();
    var d=new Date(year,month-1,1);
    var max=(month==2?28+((year%4==0)&&((year%100!=0)||(year%400==0))?1:0):30+(month<8?1-((month-1)%2):(month-1)%2));
    var html='<table border=0 cellpadding=1 cellspacing=0 bgcolor="#13406E"><tr><td><table border=0 cellpadding=3 cellspacing=1 width=150><tr bgcolor="#13406E"><td align=center>';
	html+='<a href="javascript:void(0)" onclick="renderCalendar(' + month +',' + (year-1) + ')"><img src="/easyportal/images/calendarleft.gif" border=0 width=7 height=6></a>';
	html+='<img src="/easyportal/images/separador.gif" width=6 border=0>';
	html+='<a href="javascript:void(0)" onclick="renderCalendar(' + (month>1?month-1:12)+',' + (month>1?year:year-1)+ ')"><img src="/easyportal/images/calendarleft1.gif" border=0 width=3 height=6></a>';
	html+='</td><td colspan=5 align=center><font size=1 face="arial,helvetica" color=white><b>';
    html+=MONTHS[month-1]+' '+year+'</b></font></td><td align=center>';
	html+='<a href="javascript:void(0)" onclick="renderCalendar('+(month<12?month+1:1)+','+(month<12?year:year+1)+')"><img src="/easyportal/images/calendarright1.gif" width=3 height=6 border=0></a>';
	html+='<img src="/easyportal/images/separador.gif" width=6 border=0>';
	html+='<a href="javascript:void(0)" onclick="renderCalendar('+ month + ',' + (year+1) + ')"><img src="/easyportal/images/calendarright.gif" width=7 height=6 border=0></a>';
    html+='</td></tr><tr bgcolor="#DCDCDC"><td align=center><font size=1 face="verdana,helvetica"><b>D</b></font></td><td align=center><font size=1 face="verdana,helvetica"><b>S</b></font></td><td align=center><font size=1 face="verdana,helvetica"><b>T</b></font></td><td align=center><font size=1 face="verdana,helvetica"><b>Q</b></font></td><td align=center><font size=1 face="verdana,helvetica"><b>Q</b></font></td><td align=center><font size=1 face="verdana,helvetica"><b>S</b></font></td><td align=center><font size=1 face="verdana,helvetica"><b>S</b></font></td></tr>';
    var offset=d.getDay()+1;
    var count=1,i,a;
    for (i=1;i<=max;i++) {
        if (count==1) html+='<tr bgcolor=white>';
        if ((i==1)&&(offset>1)) {
            html+='<td colspan='+(offset-1)+' bgcolor="#F3F3F3"><font size=1>&nbsp;</font></td>';
            count=offset;
        }
        a = retroactive || ((year>t_y)||((year==t_y)&&((month>t_m)||((month==t_m)&&(i>t_d)))));
		var hoje = ((year==t_y)&&(month==t_m)&&(i==t_d));
        html+='<td align=center ' + (hoje?'bgcolor=#FFCFCF':'') + '><font face="arial,helvetica" size=1'+
            (a?'><a href="javascript:void(0)" onclick="setDateValue('+year+','+month+','+i+')"><b>':' color=gray>')+i+(a?'</b></a>':'')+
            '</font></td>';
        if ((i==max)&&(count<7)) {
            html+='<td colspan='+(7-count)+' bgcolor="#F3F3F3"><font size=1>&nbsp;</font></td>';
            count=7;
        }
        count++;
        if (count>7) {
            count=1;
            html+='</tr>';
        }
    }
    html+='</table></td></tr></table>';
    if (document.layers) {
        CAL_OPEN.document.open('text/html');
        CAL_OPEN.document.write(html);
        CAL_OPEN.document.close();
    } else
        CAL_OPEN.innerHTML=html;
}



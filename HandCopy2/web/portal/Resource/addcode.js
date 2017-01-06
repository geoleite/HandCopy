if(typeof _STNS!="undefined")
{
	function stGetMessage(s,a)
	{
		var _r=_STNS;
			if(_STNS._aStMenus[0])
				_STNS._aStMenus[0].fvGetMsg(s,a);
	};	
	function stSendMessage(s)
	{
		location.assign("DMM:"+s);
	};
	function stGetMenuSelect()
	{
		var m=this.oParMenu,s="EDIT_NODE[",mid=m.sId;
		for(var i in m.oSelect)
			if(m.oSelect[i])
				s+=mid+"_"+m.oSelect[i].oParPopup.iNid+"_"+m.oSelect[i].iNid+",";
		s=s.substr(0,s.length-1);
		s+="]";
		stSendMessage(s);
		return true;
	};
	function stInitMessage()
	{
		if(_STNS._aStMenus[0])
		{
			for(var i=0;i<_STNS._aStMenus[0].aPopups.length;i++)
				for(var j=0;j<_STNS._aStMenus[0].aPopups[i].aItems.length;j++)
				{
					_STNS._aStMenus[0].aPopups[i].aItems[j].fbAttachEnt("mousedown",stGetMenuSelect);
					_STNS._aStMenus[0].aPopups[i].aItems[j].fbAttachEnt("dblclick",stEditText);
				}
			_STNS._aStMenus[0].fbAttachEnt('blurinbox',stGetInBoxValue);
		}
		_STNS._STCanvas.fbAttachEnt("clearall",stClearAll);
		_STNS._STCanvas.fbAttachEnt("resize",stReSelect);
		_STNS._STCanvas.fbAttachEnt('startediting',stEditStart);
		_STNS._STCanvas.fbAttachEnt('endediting',stEditEnd);
	};
	function stEditStart()
	{
		stSendMessage("CANVAS_START_EDITING");
		return true;
	};
	function stEditEnd()
	{
		stSendMessage("CANVAS_END_EDITING");
		return true;	
	};
	function stGetInBoxValue()
	{
		var m=this;
		if(m.oEdit)
			stEditText.call(m.oEdit,this.fsGetInBoxValue());
	};
	function stReSelect()
	{
		var m=_STNS._aStMenus[0],s="EDIT_NODE[";
		if(m)
		{
			for(var i in m.oSelect)
				if(m.oSelect[i])
					s+=m.sId+"_"+m.oSelect[i].oParPopup.iNid+"_"+m.oSelect[i].iNid+",";
			s=s.substr(0,s.length-1);
			s+="]";			
		}
		stGetMessage("EDIT_NODE",s);
		return true;	
	};
	function stEditText(s)
	{
//*&2:null ; &3:don't change node text;
		if(s==="")
			stSendMessage("EDIT_NODE_TEXT["+this.oParMenu.sId+"_"+this.oParPopup.iNid+"_"+this.iNid+",&2]");
		else if(typeof s=="undefined" || s===0)
			stSendMessage("EDIT_NODE_TEXT["+this.oParMenu.sId+"_"+this.oParPopup.iNid+"_"+this.iNid+",&3]");	
		else
			stSendMessage("EDIT_NODE_TEXT["+this.oParMenu.sId+"_"+this.oParPopup.iNid+"_"+this.iNid+","+stSoCode(s)+"]");
	};
	function stSoCode(s)
	{
		if(!s) return s;
		var re=/&/g;
		s=s.replace(re,"&@");
		re=/%/g;
		s=s.replace(re,"%@");
		re=/,/g;
		s=s.replace(re,"&1");
		return s;
	};
	function stClearAll()
	{
		stSendMessage("CLEAR_ALL");
	};
	stInitMessage();
}

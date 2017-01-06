function setOp(operacao) {
    var f = document.forms[0];
    var c = f.elements['op'];
    c.value = operacao;
    f.submit();
}

function setOpForm(formname, operacao) {
    var f = document.forms[formname];
    var c = f.elements['op'];
    c.value = operacao;
    f.submit();
}

function setOpPortal(formname, operacao, page) {
    //alert(formname + ' ' + operacao + ' ' + page );
    var f = document.forms[formname];
    var c = f.elements['op'];
    c.value = operacao;
    //alert(c.value);
    var p = f.elements['urlCanal'];
    p.value=page;
    //alert(p.value);
    f.submit();
}

function setfocus() {
    var campos = document.forms[0].elements;
    for (var i=0; i < campos.length; i++) {
        if (campos[i].type != "hidden" && campos[i].type != "button" && 
            campos[i].type != "reset" && campos[i].type != "submit") {

            campos[i].focus();
            return;
        }
    }
    return;
}
 
/**
 * Define o foco para o proximo campo do formulário
 */
function nextField(fieldActual, e) {
    if (e && e.keyCode == 13) {
        var f = document.forms[0];
        var fields = f.elements;
        for(i=0; i < fields.length; i++) {
            if (fields[i]  == fieldActual) {
                fields[i+1].focus();
                return;
            }
        }
    }
}
function enter(e) {
    if (e && e.keyCode == 13)
        document.forms[0].submit();
}
    
function formata(val)
{
    var pass = val.value;
    var expr = /[0123456789]/;
		
    for(i=0; i<pass.length; i++){
        // charAt -> retorna o caractere posicionado no índice especificado
        var lchar = val.value.charAt(i);
        var nchar = val.value.charAt(i+1);
	
        if(i==0){
            // search -> retorna um valor inteiro, indicando a posição do inicio da primeira
            // ocorrência de expReg dentro de instStr. Se nenhuma ocorrencia for encontrada o método retornara -1
            // instStr.search(expReg);
            if ((lchar.search(expr) != 0) || (lchar>3)){
                val.value = "";
            }
		   
        }else if(i==1){
			   
            if(lchar.search(expr) != 0){
                // substring(indice1,indice2)
                // indice1, indice2 -> será usado para delimitar a string
                var tst1 = val.value.substring(0,(i));
                val.value = tst1;				
                continue;			
            }
			   
            if ((nchar != '/') && (nchar != '')){
                var tst1 = val.value.substring(0, (i)+1);
				
                if(nchar.search(expr) != 0) 
                    var tst2 = val.value.substring(i+2, pass.length);
                else
                    var tst2 = val.value.substring(i+1, pass.length);
	
                val.value = tst1 + '/' + tst2;
            }

        }else if(i==4){
			
            if(lchar.search(expr) != 0){
                var tst1 = val.value.substring(0, (i));
                val.value = tst1;
                continue;			
            }
		
            if	((nchar != '/') && (nchar != '')){
                var tst1 = val.value.substring(0, (i)+1);

                if(nchar.search(expr) != 0) 
                    var tst2 = val.value.substring(i+2, pass.length);
                else
                    var tst2 = val.value.substring(i+1, pass.length);
	
                val.value = tst1 + '/' + tst2;
            }
        }
		
        if(i>=6){
            if(lchar.search(expr) != 0) {
                var tst1 = val.value.substring(0, (i));
                val.value = tst1;			
            }
        }
    }
	
    if(pass.length>10)
        val.value = val.value.substring(0, 10);
    return true;
}

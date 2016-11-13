function clickme() {
	var xmlHttp = new XMLHttpRequest();
        var token = document.getElementById("access_token").value;
	var val = getRadioVal(document.getElementById('catalog-form'), 'filter-catalog');
	var get = "http://localhost:8080/Client/showcatalog?name="+document.getElementById('search-cat').value+"&filter="+val+"&access_token="+token;
    xmlHttp.open( "GET", get, false ); // false for synchronous request
    xmlHttp.send();
	document.getElementById("catalog-list").innerHTML='';
	document.getElementById("catalog-list").innerHTML=xmlHttp.responseText;
}

function getRadioVal(form, name) {
    var val;
    var radios = form.elements[name];
    
    for (var i=0, len=radios.length; i<len; i++) {
        if ( radios[i].checked ) {
            val = radios[i].value;
            break; 
        }
    }
    return val;
}


function liked(name) {
    var val = document.getElementById(name).value;
    var lik = "click-like"+val+"-y";
    var valBefore = parseInt(document.getElementById("like"+val).value);
    var access_token = document.getElementById("access_token").value;
    if (name===lik) {
        var valAfter = valBefore-1;
        var xmlHttp = new XMLHttpRequest();
        var get = "route.jsp?catalogid="+val+"&action=unlike"+"&access_token="+access_token+"&catalogid="+val;
        xmlHttp.open( "GET", get, false ); // false for synchronous request
        xmlHttp.send();
        if (xmlHttp.status === 200) {
            document.getElementById("like"+val).value = valAfter;
            document.getElementById('catalog-likes'+val).innerHTML=valAfter+" like";
            document.getElementById(name).setAttribute('id', 'click-like'+val+'-n');
            document.getElementById('click-like'+val+'-a').setAttribute('name', 'click-like'+val+'-n');
            document.getElementById('click-like'+val+'-a').setAttribute('style', 'color:blue');	
            document.getElementById('click-like'+val+'-a').innerHTML = "<b>LIKE</b>";
        }
    }
    else {
        var valAfter = valBefore+1;
        var xmlHttp = new XMLHttpRequest();
        var get = "route.jsp?catalogid="+val+"&action=like"+"&access_token="+access_token+"&catalogid="+val;
        xmlHttp.open( "GET", get, false ); // false for synchronous request
        xmlHttp.send();
        if (xmlHttp.status === 200) {
            document.getElementById("like"+val).value = valAfter;
            document.getElementById('catalog-likes'+val).innerHTML=valAfter+" like";
            document.getElementById(name).setAttribute('id', 'click-like'+val+'-y');
            document.getElementById('click-like'+val+'-a').setAttribute('name', 'click-like'+val+'-y');
            document.getElementById('click-like'+val+'-a').setAttribute('style', 'color:red');
            document.getElementById('click-like'+val+'-a').innerHTML = "<b>LIKED</b>";
        }
    }
}

function calculateTotal() {
	var quantity = document.getElementById('quantity').value;
	var total = quantity*document.getElementById('price').value;
	total = total.toString();
	var count = total.toString().length;
	var cnt = 0;
	for(i=count; i>0;i--) {
		if (cnt == 3) {
			cnt = 0;
			total = total.slice(0, i)+ '.'+ total.slice(i);
		}
		cnt++;
	}
	document.getElementById('calculate-total-price').innerHTML = total;
}

function confirmed() {
	document.getElementById('err-credit-card').innerHTML="";
	document.getElementById('err-verf-num').innerHTML="";
	document.getElementById('verf').style.borderColor = "";
	document.getElementById('credit-card').style.borderColor = "";
	if (document.getElementById('credit-card').value.length < 12 || document.getElementById('credit-card').value.length > 12) {
		document.getElementById('err-credit-card').style.color = "red";
		document.getElementById('err-credit-card').innerHTML="Kredit card harus 12 digit";
		document.getElementById('credit-card').style.borderColor = "red";
		if (document.getElementById('verf').value.length < 3 || document.getElementById('verf').value.length > 3) {
			document.getElementById('err-verf-num').style.color = "red";
			document.getElementById('err-verf-num').innerHTML="Kode verifikasi harus 3 digit";
			document.getElementById('verf').style.borderColor = "red";
		}
		return false;
	}
	return confirm("Apakah data yang anda masukkan sudah benar?");
}

function cancel() {
	window.location = 'catalog.php';
}

function showCatalog () {
    var find = document.getElementById('catalog-list');
    var token = document.getElementById('access_token').value;
    if (find!==null) {
        var xmlHttp = new XMLHttpRequest();
        var get = "http://localhost:8080/Client/showcatalog?name=\"\"&filter=\"\"&access_token="+token;
        xmlHttp.open( "GET", get, false ); // false for synchronous requefilterst
        xmlHttp.send();
        document.getElementById('catalog-list').innerHTML = xmlHttp.responseText;
    }
}

function showProduct(){
    var find = document.getElementById('product-list');
    if(find!=null){
        var id = document.getElementById('id_user').value;
        var xmlHttp = new XMLHttpRequest();
        var get = "http://localhost:8080/Client/showproduct?id=" + id;
        xmlHttp.open( "GET", get, false ); // false for synchronous requefilterst
        xmlHttp.send();
        document.getElementById('product-list').innerHTML = xmlHttp.responseText;
    }
}

/*
function editProduct(){
    var find = document.getElementById('edit-list');
    if(find!=null){
        var id = document.getElementById('id_user').value;
        var xmlHttp = new XMLHttpRequest();
        var get = "http://localhost:8080/Client/editproduct?id=" + id;
        xmlHttp.open( "GET", get, false ); // false for synchronous requefilterst
        xmlHttp.send();
        document.getElementById('edit-list').innerHTML = xmlHttp.responseText;
    }
}

editProduct();
*/
showProduct();
showCatalog();
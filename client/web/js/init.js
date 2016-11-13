function checklogin() {
	var find = document.getElementById('userdata');
	if (find!=null) {
		var xmlHttp = new XMLHttpRequest();
		var get = "index.php?action=getuserdata";
		xmlHttp.open( "GET", get, false ); // false for synchronous request
		xmlHttp.send();
		find.innerHTML = xmlHttp.responseText;
	}
}

function showMenu () {
	var find = document.getElementById('menu');
	if (find!=null) {
		var xmlHttp = new XMLHttpRequest();
		var get = "index.php?action=menu";
		xmlHttp.open( "GET", get, false ); // false for synchronous request
		xmlHttp.send();
		find.innerHTML = xmlHttp.responseText;
	}
}

function showCatalog () {
	var find = document.getElementById('catalog-list');
	if (find!=null) {
		var xmlHttp = new XMLHttpRequest();
		var get = "/showcatalog";
		xmlHttp.open( "GET", get, false ); // false for synchronous request
		xmlHttp.send();
		document.getElementById('catalog-list').innerHTML = xmlHttp.responseText;
	}
}

function showSales() {
    var find = document.getElementById('sales-list');
    if (find!==null) {
        var token = document.getElementById('access_token').value;
        var xmlHttp = new XMLHttpRequest();
        var get = "http://localhost:8080/Client/showsales?access_token="+token;
        xmlHttp.open( "GET", get, false ); // false for synchronous requefilterst
        xmlHttp.send();
        document.getElementById('sales-list').innerHTML = xmlHttp.responseText;
    }
}

function showPurchases() {
    var find = document.getElementById('purchases-list');
    if (find!==null) {
        var token = document.getElementById('access_token').value;
        var xmlHttp = new XMLHttpRequest();
        var get = "http://localhost:8080/Client/showpurchases?access_token="+token;
        xmlHttp.open( "GET", get, false ); // false for synchronous requefilterst
        xmlHttp.send();
        document.getElementById('purchases-list').innerHTML = xmlHttp.responseText;
    }
}

function redirOrNot () {
	var find = document.getElementById('forredir');
	if (find!=null) {
		var xmlHttp = new XMLHttpRequest();
		var get = "index.php?action=redirornot";
		xmlHttp.open( "GET", get, false ); // false for synchronous request
		xmlHttp.send();
		if (xmlHttp.responseText=='true') window.location = 'catalog.php';
	}
}

function errMsg () {
	var find = document.getElementById('login-err');
	if (find!=null) {
		var xmlHttp = new XMLHttpRequest();
		var get = "index.php?action=login-err";
		xmlHttp.open( "GET", get, false ); // false for synchronous request
		xmlHttp.send();
		find.innerHTML = xmlHttp.responseText;
		get = "index.php?action=register-err";
		xmlHttp.open( "GET", get, false ); // false for synchronous request
		xmlHttp.send();
		document.getElementById('register-err').innerHTML = xmlHttp.responseText;
	}	
}

function selectedMenu() {
	var find = document.getElementById("id_page");
	if (find!=null) {
		var id_page = document.getElementById("id_page").value;
		var id_span = "span"+id_page;
		document.getElementById(id_page).style.backgroundColor = "rgb(74, 134, 232)";
		document.getElementById(id_span).style.color = "white";
	}
}

function showProduct() {
	var find = document.getElementById('yourproduct-list');
	if (find!=null) {
		var xmlHttp = new XMLHttpRequest();
		var get = "index.php?action=showproduct";
		xmlHttp.open( "GET", get, false ); // what?
		xmlHttp.send(); //what?
		document.getElementById('yourproduct-list').innerHTML = xmlHttp.responseText; //what?
	}
}

/*redirOrNot();
checklogin(); //menampilkan nama user yang login
showMenu(); //Menampilkan menu bar
showCatalog(); //menampilkan catalog
errMsg();*/
showSales();
showPurchases();
selectedMenu();
//showProduct();
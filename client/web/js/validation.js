function validateForm (){
	var x = document.forms["register"]["username"].value;
	var ok = "true";
	if (x == null || x == "") {
		document.getElementById("inputunamelog").innerHTML = "Username tidak boleh kosong";
		document.getElementById("inputunamelog").style.color = "red";
		document.getElementById("username1").style.color="red";
		document.getElementById("username1").style.borderColor="red";
		ok = "false";
	}
	else if (x.length<3) {
		document.getElementById("inputunamelog").innerHTML = "Username minimal 6 karakter";
		document.getElementById("inputunamelog").style.color = "red";
		document.getElementById("username1").style.color="red";
		document.getElementById("username1").style.borderColor="red";
		ok = "false";
	}
	
	x = document.forms["register"]["name"].value;
	if (x==null || x=="") {
		document.getElementById("inputnamelog").innerHTML = "Nama tidak boleh kosong";
		document.getElementById("inputnamelog").style.color = "red";
		document.getElementById("name").style.color="red";
		document.getElementById("name").style.borderColor="red";
		ok = "false";
	}
	
	else {
		document.getElementById("inputnamelog").innerHTML = "";
		document.getElementById("name").style.color="black";
		document.getElementById("name").style.borderColor="#ccc";
	}
	
	x = document.forms["register"]["email"].value;
	var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (x == null || x == "") {
    	document.getElementById("inputemaillog").innerHTML = "Email tidak boleh kosong";
		document.getElementById("inputemaillog").style.color = "red";
		document.getElementById("email").style.color="red";
		document.getElementById("email").style.borderColor="red";
		ok = "false";
    }
    else if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
    	document.getElementById("inputemaillog").innerHTML = "Email tidak valid";
		document.getElementById("inputemaillog").style.color = "red";
		document.getElementById("email").style.color="red";
		document.getElementById("email").style.borderColor="red";
		ok = "false";
    }
	
	x = document.forms["register"]["password"].value;
	if (x == null || x == "") {
		document.getElementById("inputpass").innerHTML = "Password tidak boleh kosong";
		document.getElementById("inputpass").style.color = "red";
		document.getElementById("password1").style.color="red";
		document.getElementById("password1").style.borderColor="red";
		ok = "false";
	}
	else if (x.length < 6) {
		document.getElementById("inputpass").innerHTML = "Password minimal 6 karakter";
		document.getElementById("inputpass").style.color = "red";
		document.getElementById("password1").style.color="red";
		document.getElementById("password1").style.borderColor="red";
		ok = "false";
	}
	
	var y = document.forms["register"]["confirm-password"].value;
	if ( x.length >= 6 && x!==y) {
		document.getElementById("inputpass").innerHTML = "Password tidak cocok";
		document.getElementById("inputpass").style.color = "red";
		document.getElementById("password1").style.color="red";
		document.getElementById("password1").style.borderColor="red";
		ok = "false";
	}
	
	x = document.forms["register"]["address"].value;
	if (x==null || x=="") {
		document.getElementById("inputaddresslog").innerHTML = "Alamat tidak boleh kosong";
		document.getElementById("inputaddresslog").style.color = "red";
		document.getElementById("address").style.color="red";
		document.getElementById("address").style.borderColor="red";
		ok = "false";
	}
	
	x = document.forms["register"]["postal"].value;
	if (x == null || x=="") {
		document.getElementById("inputpostlog").innerHTML = "Postal tidak boleh kosong";
		document.getElementById("inputpostlog").style.color = "red";
		document.getElementById("postal").style.color="red";
		document.getElementById("postal").style.borderColor="red";
		ok = "false";
	}
	
	x = document.forms["register"]["phone"].value;
	if (x == null || x=="") {
		document.getElementById("inputphonelog").innerHTML = "Nomor telepon tidak boleh kosong";
		document.getElementById("inputphonelog").style.color = "red";
		document.getElementById("phone").style.color="red";
		document.getElementById("phone").style.borderColor="red";
		ok = "false";
	}
	if (ok == "false") return false;
}

function validateLogin () {
	document.getElementById("inputunamelog").innerHTML="Wajib diisi<br>";
	document.getElementById("inputunamelog").style.color="red";
	document.getElementById("inputunamelog").style.display="none";
	document.getElementById("username").style.borderColor="#ccc";
	document.getElementById("inputpasslog").innerHTML="<br>Wajib diisi<br>";
	document.getElementById("inputpasslog").style.color="red";
	document.getElementById("inputpasslog").style.display="none";
	document.getElementById("password").style.borderColor="#ccc";

	var x = document.forms["login"]["username"].value;
	var ok = "true";
	if (x==null || x=="" || x.length<3) {
		document.getElementById("inputunamelog").style.display="initial";
		document.getElementById("username").style.borderColor="red";
		ok = "false";
	}
	
	x = document.forms["login"]["password"].value;
	if (x==null || x=="") {
		document.getElementById("inputpasslog").style.display="initial";
		document.getElementById("password").style.borderColor="red";
		ok = "false";
	}
	
	if (ok=="false") return false;
}
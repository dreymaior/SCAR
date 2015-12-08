<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario</title>
<style>
@CHARSET "UTF-8";
html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, hr, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, font, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td {
  margin:0; padding:0; border:0; background:transparent;
  /*vertical-align: baseline;*/
}

/* lists */
.list-full, .list-full li,
.list-auto, .list-auto li { width: 100%; float: left; display: block; position: relative; }
.list-auto, .list-auto li { width: auto; }

/* floats */
.float-l { float: left; }
.float-r { float: right; }

body {
  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
  color: #333;
  text-shadow: 0 1px 0 #fff;
}

header {
  min-height: 60px;
  position: fixed;
  top: 0;
  right: 0;
  left: 0;
  border-bottom: 1px solid #ccc;
  background: #ECECEC;
  z-index: 2;
}

header h1 {
  padding: 10px 0 0 10px;
}

header h1 a {
  color: #333;
}

header ul {
  padding: 15px 10px 0 0;
}

header li {
  border-left: 1px solid #ccc;
}

header li:first-child {
  border: none;
}

header li a {
  display: block;
  padding: 0 10px;
  color: #999;
  font-size: 16px;
  line-height: 30px;
  text-decoration: none;
  -webkit-transition: all 300ms ease;
  transition: all 300ms ease;
}

header li a:hover {
  color: #333;
}

input#control-nav {
  visibility: hidden;
  position: absolute;
  left: -9999px;
  opacity: 0;
}

/* content */
section {
  padding: 80px 20px 50px;
  border-top: 1px solid #ccc;
  font-size: 20px;
  line-height: 24px;
}

section:after {
  content: "";
  display: block;
  clear: both;
}

section img {
  width: 44%;
  margin: 0 0 10px 4%;
}

section p {
  padding: 0 0 20px;
}

.highlights {
  position: relative;
}

.highlights input {
  visibility: hidden;
  position: absolute;
  left: -9999px;
  opacity: 0;
}

.highlights-item {
  float: left;
  margin: 0 0 0 2%;
  width: 32%;
  text-align: center;
}

.highlights-item:first-of-type {
  margin-left: 0;
}

.highlights-item img {
  display: block;
  width: 100%;
  margin: 0 0 5px;
}

.highlights-item p {
  font-size: 14px;
}

.highlights-button {
  display: inline-block;
  padding: 10px 15px 8px;
  cursor: pointer;
  border-radius: 3px;
  border: 1px solid #ccc;
  background-color: #ececec;
  -webkit-transition: background-color 300ms ease-in-out, border-color 300ms ease-in-out;
  transition: background-color 300ms ease-in-out, border-color 300ms ease-in-out;
}

.highlights-button:hover {
  border: 1px solid #ececec;
  background-color: #ccc;
}

.highlights-buttons {
  display: none;
  clear: both;
  text-align: center;
}

.highlights-buttons label {
  display: inline-block;
  width: 15px;
  height: 15px;
  margin: 0 10px; 
  border-radius: 10px;
  background-color: #ccc;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  text-indent: -9999px;
  -webkit-transition: background-color 300ms ease-in-out;
  transition: background-color 300ms ease-in-out;
}

.highlights-buttons label:hover {
  background-color: #777;
}

/* init modal */
.modal {
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  z-index: 10;
  opacity: 0;
  visibility: hidden;
  -webkit-transition: all 0.5s 0.5s ease-in-out;
  transition: all 0.5s 0.5s ease-in-out;
}

.modal-content {
  padding: 10px;
  max-width: 600px;
  min-width: 360px;
  max-height: 85%;
  overflow: auto;
  position: absolute;
  top: 5%;
  left: 50%;
  z-index: 2;
  opacity: 0;
  border-radius: 3px;
  background: #fff;
  -webkit-transform: translate(-50%, 0);
  -ms-transform: translate(-50%, 0);
  transform: translate(-50%, 0);
  
  -webkit-transition: all 0.5s ease-in-out;
  transition: all 0.5s ease-in-out;
}

.modal-content img {
  display: block;
  width: 100%;
  margin: 10px 0 0;
}

.modal-content p {
  padding-top: 10px;
  text-align: justify;
}

.modal-close {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  background-color: rgba(0,0,0,0.5);
}

.modal-close:after {
  content: "X";
  float: right;
  margin: 5px 5px 0 0;
  width: 30px;
  height: 30px;
  position: relative;
  z-index: 3;
  text-align: center;
  line-height: 30px;
  cursor: pointer;
  background-color: rgba(255,255,255,0.8);
  border-radius: 20px;
  box-shadow: 0 0 3px #000;
}

input[id*="modal_"] {
  position: fixed;
  left: -9999px;
  top: 50%;
  opacity: 0;
}
input[id*="modal_"]:checked + div.modal {
  opacity: 1;
  visibility: visible;
  -webkit-transition-delay: 0s;
  -ms-transition-delay: 0s;
  transition-delay: 0s;
}

input[id*="modal_"]:checked + div.modal .modal-content {
  opacity: 1;
  -webkit-transform: translate(-50%, 0);
  -ms-transform: translate(-50%, 0);
  transform: translate(-50%, 0);
  -webkit-transition-delay: 0.5s;
  -ms-transition-delay: 0.5s;
  transition-delay: 0.5s;
}

@media screen and (max-width: 767px) {
  header nav {
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    width: 250px;
    border-left: 1px solid #ccc;
    background: #fff;
    overflow-x: auto;
    z-index: 2;
    -webkit-transition: all 500ms ease;
    transition: all 500ms ease;
    -webkit-transform: translate(100%, 0);
    -ms-transform: translate(100%, 0);
    transform: translate(100%, 0);
  }

  header ul.list-auto {
    padding: 0;
  }

  header ul.list-auto li {
    width: 100%;
    border: solid #ccc;
    border-width: 0 0 1px;
  }

  header li a {
    padding: 15px 10px;
  }

  header li a:hover {
    background-color: #ccc;
  }

  .control-nav { /* label icon */
    position: absolute;
    right: 20px;
    top: 20px;
    display: block;
    width: 30px;
    padding: 5px 0;
    border: solid #333;
    border-width: 3px 0;
    z-index: 2;
    cursor: pointer;
  }

  .control-nav:before {
    content: "";
    display: block;
    height: 3px;
    background: #333;
  }

  .control-nav-close {
    position: fixed; /* label layer */
    right: 0;
    top: 0;
    bottom: 0;
    left: 0;
    display: block;
    z-index: 1;
    background: rgba(0,0,0,0.4);
    -webkit-transition: all 500ms ease;
    transition: all 500ms ease;
    -webkit-transform: translate(100%, 0);
    -ms-transform: translate(100%, 0);
    transform: translate(100%, 0);
  }

  /* checked nav */
  input#control-nav {
    display: block;
  }

  input#control-nav:focus ~ .control-nav {
    border-color: #000;
    box-shadow: 0px 0px 9px rgba(0,0,0,0.3);
  }

  input#control-nav:focus ~ .control-nav:before {
    background: #000;
  }

  input#control-nav:checked ~ nav,
  input#control-nav:checked ~ .control-nav-close {
    -webkit-transform: translate(0, 0);
    -ms-transform: translate(0, 0);
    transform: translate(0, 0);
  }

  header+section {
    padding-top: 80px;
  }

  section {
    padding: 30px 15px 10px;
  }

  .highlights {
    -webkit-transition: all 500ms ease-in-out;
    transition: all 500ms ease-in-out;
  }

  .highlights-item {
    width: 100%;
    margin-left: 0;
    position: absolute;
    top: 0;
    opacity: 0;
    visibility: hidden;
    -webkit-transition: all 500ms ease-in-out;
    transition: all 500ms ease-in-out;
    -webkit-transform: scale(0.9);
    -ms-transform: scale(0.9);
    transform: scale(0.9);
  }

  .highlights-item p {
    opacity: 0;
    -webkit-transition: opacity 500ms 500ms ease-in-out;
    transition: opacity 500ms 500ms ease-in-out;
  }

  .highlights-buttons {
    display: block;
    padding-top: 10px;
  }

  /*checked*/
  .highlights input:checked + div {
    position: relative;
    opacity: 1;
    visibility: visible;
    z-index: 1;
    -webkit-transform: scale(1);
    -ms-transform: scale(1);
    transform: scale(1);
  }

  .highlights input:checked + div p {
    opacity: 1;
  }

  .highlights input:nth-of-type(1):checked ~ .highlights-buttons label:nth-child(1),
  .highlights input:nth-of-type(2):checked ~ .highlights-buttons label:nth-child(2),
  .highlights input:nth-of-type(3):checked ~ .highlights-buttons label:nth-child(3) {
    background-color: #000
  }

  .modal-content {
    padding: 10px 5%;
    min-width: 88%;
  }
}

@media screen and (max-width: 480px) {
  header h1 {
    font-size: 20px;
    line-height: 40px;
  }
}

footer {
  min-height: 60px;
  position: fixed;
  right: 0;
  left: 0;
  bottom: 0;
  border-bottom: 1px solid #ccc;
  background: #ECECEC;
  z-index: 2;
}

</style>
</head>
<body>
<header>
      <h1 class="float-l">
        <a href="/SCAR" title="Titulo do Site">SCAR</a>
      </h1>
      
      <input type="checkbox" id="control-nav" />
      <label for="control-nav" class="control-nav"></label>
      <label for="control-nav" class="control-nav-close"></label>

      <nav class="float-r">
        <ul class="list-auto">
          <li>
          	<a href="/SCAR/"/>Home</a>
          </li>
          <li>
            <a href="/SCAR/usuarios"/>Usuários</a>
          </li>
          <li>
            <a href="/SCAR/sensor"/>Sensores</a>
          </li>
          <li>
            <a href="<c:url value="estrutura"/>" title="Estrutura">Estrutura</a>
          </li>
          <li>
            <a href="<c:url value="cftv"/> title="Cftv">CFTV</a>
          </li>
          <li>
            <a href="<c:url value="log"/>" title="Log">Log</a>
          </li>
          <li>
            <a href="/admin/sensores">Admin / Sensores</a>
          </li>
        </ul>
      </nav>
    </header>
    
    <br/>
    <br/>
    <br/>
    
<ul>
	<c:forEach items="${errors}" var="error">
		<li>${error.category } - ${error.message }</li>
	</c:forEach>
</ul>

<!-- <form action="adiciona">  -->
<form action="<c:url value="/admin/sensores"/>" method="PUT">
	<fieldset>
		<legend>Adicionar Sensor</legend>
		
		<label for="nome">Nome:</label>
		<input id="nome" type="text" name="sensor.nome" />
		
		<label for="tipo">Tipo:</label>
		<input id="tipo" type="text" name="sensor.tipo" />
		
		<button type="submit">Enviar</button>
	</fieldset>
</form>
    
</body>
</html>
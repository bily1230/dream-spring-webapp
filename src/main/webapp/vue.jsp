<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<body>
	<div id="app">
	<input v-model.lazy.trim="checkedNames"></input>
	<div>{{checkedNames}}</div>
	<button-counter></button-counter>
	</div>
</body>
<script  src="./js/jquery-1.11.3.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script type="text/javascript">

Vue.component('button-counter', {
	data: function(){
		return {
			count: 0
		}
	},
	template:'<button v-on:click="count++"  value="提交">111{{count}}</button>'
	
})
var app =new Vue({
	el:'#app',
	data: {
		checkedNames:''
	},
	methods : {
		submit : function(name){
			this.name = name;
			alert("提交");
		}
	}
	
})
$(function(){
	$("#name").click(function(){
		app.submit("aaa");
	})
})
</script>
</html>

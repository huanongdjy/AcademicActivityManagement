(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-a60d5bd2"],{9429:function(t,e,a){"use strict";var o=a("b7e3"),s=a.n(o);s.a},b7e3:function(t,e,a){},eff8:function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("Input",{staticClass:"search",attrs:{search:"",placeholder:"请输入名称"},on:{"on-search":t.mysearch},model:{value:t.searchValue,callback:function(e){t.searchValue=e},expression:"searchValue"}},[a("Icon",{attrs:{slot:"suffix",type:"ios-search"},slot:"suffix"})],1),a("br"),a("br"),a("Table",{attrs:{border:"",data:t.tableData1,columns:t.tableColumns1}}),a("div",{staticStyle:{margin:"10px",overflow:"hidden"}},[a("div",{staticStyle:{float:"right"}},[a("Page",{attrs:{total:t.total,current:t.currentPage},on:{"on-change":t.changePage}})],1)]),a("Modal",{attrs:{title:t.title},model:{value:t.modal,callback:function(e){t.modal=e},expression:"modal"}},[a("Form",{ref:"formCustom",attrs:{model:t.formCustom,rules:t.ruleCustom,"label-width":80}},[a("FormItem",{attrs:{label:"菜单名称",prop:"title"}},[a("Input",{attrs:{type:"text"},model:{value:t.formCustom.title,callback:function(e){t.$set(t.formCustom,"title",e)},expression:"formCustom.title"}})],1),a("FormItem",{attrs:{label:"权限",prop:"access"}},[a("select",{directives:[{name:"model",rawName:"v-model",value:t.formCustom.access,expression:"formCustom.access"}],on:{change:function(e){var a=Array.prototype.filter.call(e.target.options,function(t){return t.selected}).map(function(t){var e="_value"in t?t._value:t.value;return e});t.$set(t.formCustom,"access",e.target.multiple?a:a[0])}}},[a("option",{attrs:{value:"sysadmin"}},[t._v("sysadmin")]),a("option",{attrs:{value:"admin"}},[t._v("admin")])])])],1),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("Button",{attrs:{type:"text",size:"large"},on:{click:t.cancel}},[t._v("取消")]),a("Button",{attrs:{type:"primary",size:"large"},on:{click:t.ok}},[t._v("确定")])],1)],1)],1)},s=[],r=(a("ac6a"),a("21b0")),n={data:function(){var t=this,e=function(t,e,a){""===e?a(new Error("请输入菜单名称")):a()},a=function(t,e,a){""===e?a(new Error("请选择权限")):a()};return{formCustom:{title:"",access:"",parent_id:""},title:"",tomethod:"",searchValue:"",ruleCustom:{title:[{validator:e,trigger:"blur"}],access:[{validator:a,trigger:"blur"}]},modal:!1,pageSize:10,total:0,currentPage:1,tableData1:[],tableColumns1:[{title:"菜单名称",key:"title"},{title:"权限",key:"access"},{title:"操作",key:"action",width:150,align:"center",render:function(e,a){return e("div",[e("Button",{props:{type:"primary",size:"small"},style:{marginRight:"5px"},on:{click:function(){t.show(a.index)}}},"编辑")])}}]}},methods:{changePage:function(t){var e=this;Object(r["b"])(10,t).then(function(t){var a=t.data.page;"200"===t.data.resultCode?(e.tableData1=[],a.list.forEach(function(t){e.tableData1.push(t)}),e.total=a.total,e.currentPage=a.pageNum):400===t.data.resultCode&&e.$Message.info(t.data.message)})},show:function(t){this.modal=!0;var e=this.tableData1[t];this.formCustom.title=e.title,this.formCustom.access=e.access,this.formCustom.menu_id=e.menu_id,this.formCustom.parent_id=e.parent_id,this.title="菜单信息编辑",this.tomethod="update"},ok:function(){var t=this;this.$refs["formCustom"].validate(function(e){e&&("update"===t.tomethod&&Object(r["d"])(t.formCustom).then(function(e){t.$Message.info(e.data.message),t.changePage(t.currentPage)}),t.modal=!1)})},cancel:function(){this.modal=!1},mysearch:function(){var t=this;Object(r["c"])(this.searchValue).then(function(e){200===e.data.resultCode&&0!==e.data.essays.length?(t.tableData1=[],e.data.essays.forEach(function(e){t.tableData1.push(e)})):400===e.data.resultCode?t.$Message.info(e.data.message):t.$Message.info("该菜单名称不存在")})}},created:function(){var t=this;Object(r["b"])(10,1).then(function(e){var a=e.data.page;"200"===e.data.resultCode?(a.list.forEach(function(e){t.tableData1.push(e)}),t.total=a.total,t.currentPage=a.pageNum):400===e.data.resultCode&&t.$Message.info(e.data.message)})}},l=n,i=(a("9429"),a("2877")),c=Object(i["a"])(l,o,s,!1,null,null,null);c.options.__file="menuManager.vue";e["default"]=c.exports}}]);
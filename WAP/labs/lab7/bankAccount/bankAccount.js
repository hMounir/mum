(function () {
	'use strict';
	let AccountModule= (function(){
		const createAccount = function (name,deposit) {
			return {name:name,deposit:deposit};
		};

		return {
			createAccount:function(name,deposit){
				return createAccount(name,deposit);
			}
		};
	})();
	const accountInfoList =[];

	function createNewAccount(){
		let newAccount = AccountModule.createAccount(document.getElementById('name').value,
			document.getElementById('deposit').value);
		let content="";
		accountInfoList.push(newAccount);
		if(accountInfoList .length>0){
			accountInfoList
				.forEach((value, index) => content+="Account Name: "+accountInfoList[index].name+" Balance "+accountInfoList[index].deposit+"\r\n");
			document.getElementById("accountInfoList").value=content;
		}
		document.getElementById("accountInfoList").value = '';
	}

	window.onload = ev => {document.getElementById("createAccount").onclick=createNewAccount};
})();
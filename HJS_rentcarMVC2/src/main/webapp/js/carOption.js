function getTodayDate() {
     const today = new Date();
     const year = today.getFullYear();
     const month = String(today.getMonth() + 1).padStart(2, '0'); 
     const day = String(today.getDate()).padStart(2, '0'); 
	 const dDay = year + "-" + month + "-" + day;

     return dDay;
 }

 document.getElementById('rday').setAttribute('min', getTodayDate());

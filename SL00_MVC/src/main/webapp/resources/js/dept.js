console.log("Dept Module...");

var deptService = (function(){

  function add(dept, callback, error){
    console.log("add dept...");
    $.ajax({
      type:'post',
      url:'/scott/dept/new', //새로운 url 
      data:JSON.stringify(dept), //자바스크립트의 객체를 json으로 변환
      cache:false,
      contentType:"application/json; charset=utf-8",
      beforeSend:function(xhr){
          //console.log("add dept... beforeSend");
      },
      success:function(result, status, xhr){ 
        //console.log("add dept... success");
        if(callback){
          callback(result); //에이잭스가 실행되고 난뒤 호출되는것 
        }
      },
      error:function(xhr, status, er){ 
        if(error){
          error(er);
        }
      }
    });
  } // add
  
  function remove(deptno, callback, error){
    console.log("remove dept...");
    $.ajax({
      type:'delete',
      url:'/scott/dept/'+ deptno,  
      cache:false,
      success:function(deleteResult, status, xhr){ 
        if(callback){
          callback(deleteResult);
        }
      },
      error:function(xhr, status, er){
        if(error){
          error(er);
        }
      }
    });
  } // remove
  
  return {
     add       : add,
     remove : remove
  }; //객체 

})(); //자체 호출함수
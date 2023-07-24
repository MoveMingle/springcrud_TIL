<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script> 
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }
</style>
</head>
<body>
<header>
  <h1>Sping Board</h1>
  <ul>
    <sec:authorize access="isAnonymous()">
       <li><a href="#">로그인</a></li>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
       <li><a href="#">로그아웃</a></li>
    </sec:authorize>
    <li><a href="#">회원가입</a></li>
  </ul>
</header>
<div>
  <!-- Alt + Shift + Y 자동줄바꿈 -->
  <h3><span class="material-symbols-outlined" style="vertical-align: sub">stylus_note</span>Read Page</h3>
  <div>
 <form action="/board/register" method="post">  <!-- 이것을 주석처리 하게 되면 맨밑코딩-->
 
 
 
 
 
	 <table>  
       <tbody>
         <tr>
           <th>글번호</th>
           <td><input type="text" name="bno" class="full"  readonly="readonly"  value="${ board.bno }"></td>        
         </tr> 
         <tr>
           <th>제목</th>
           <td><input type="text" name="title" class="full"  readonly="readonly"  value="${ board.title }"></td>        
         </tr> 
         <tr>
           <th>내용</th>
           <td><textarea  name="content" class="full" readonly="readonly"><c:out value="${ board.content }"></c:out></textarea></td>        
         </tr> 
         <tr>
           <th>작성자</th>
           <td><input type="text" name="writer" class="short" readonly="readonly" value="${ board.writer }"></td>        
         </tr>  
       </tbody> 
       <tfoot>
         <tr>
           <td colspan="2">
             <button type="button" data-oper="modify" class="modify">modify</button>
             <button type="button" data-oper="remove" class="remove">remove</button>
             <button type="button" data-oper="list" class="list">list</button>
           </td>
         </tr>
       </tfoot>
     </table>
    
     
     <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
     
      <input type="hidden" name="pageNum" value="${ criteria.pageNum}"> <!-- 물음표로 넘기기 힘드니깐 유지 보수한것 전달은 form태그에 담아서 -->
	<input type="hidden" name="amount" value="${ criteria.amount}">
	   <input type="hidden" name="type" value="${ criteria.type}"> <!-- 물음표로 넘기기 힘드니깐 유지 보수한것 전달은 form태그에 담아서 -->
	<input type="hidden" name="keyword" value="${ criteria.keyword}">
	</form>
  </div> 
    
</div>
  
<script>
   $(function() {
      
      var formObj = $("form");
      
      $("tfoot button").on("click", function ( event){
         var operation =  $(this).data("oper");
         if(operation === 'modify'){
             //location.href = "/board/modify?bno="+${ board.bno };
        	 formObj.attr({
                 "action":"/board/modify",
                 "method":"get"
              });
        	 formObj.submit()
         }else if(operation === 'remove'){
            if(confirm("정말 삭제할거냐?")){
               //location.href = "/board/remove?bno="+${ board.bno };
               formObj.attr({
                  "action":"/board/remove",
                  "method":"get"
               });
               formObj.submit();
            }//
         }else if(operation === 'list'){
        	//location.href="/board/list"; -> location 자체가 get 방식
          
        	
        	var pageNumTag=$("input[name=pageNum]").clone(); 
            var amountTag=$("input[name=amount]").clone(); 
            var pageNumTag=$("input[name=type]").clone(); 
            var amountTag=$("input[name=name]").clone(); 
        	
        	formObj
             .attr({
                "action":"/board/list",
                "method":"get"
             }).empty()  // 제거되기 전에 히든과 어만운트
           	.append(pageNumTag)
             .append(amountTag)
             .append(type)
             .append(keyword)
             .submit();   
          }//if
      }); //click
   });
</script>
  


</body>
</html>





<%-- 
<form id="operForm" action="/board/modify" method="get">
  <input type="hidden" id="bno" name="bno" value="<c:out value='${ board.bno }' />">
  <input type="hidden" id="pageNum" name="pageNum" value="<c:out value='${ criteria.pageNum }' />">
  <input type="hidden" id="amount" name="amount" value="<c:out value='${ criteria.amount }' />">
  <input type='hidden' id="type" name='type' value='<c:out value="${criteria.type}"/>'>  
  <input type='hidden' id="keyword" name='keyword' value='<c:out value="${criteria.keyword}"/>'>
</form>

<script>
  $(function (){
     
     var formObj = $("form");
     
     $("tfoot button").on("click", function (event){        
        var operation = $(this).data("oper");
        if(operation === 'modify'){
           //location.href = "/board/modify?bno="+${ board.bno };
           formObj.attr({
              "action":"/board/modify",
              "method":"get"
           });
            formObj.submit();
        }else if(operation === 'remove'){
           if( confirm("정말 삭제할거냐? ") ){
              //location.href = "/board/remove?bno="+${ board.bno };
              formObj.attr({
                       "action":"/board/remove",
                       "method":"get"
                    });
              formObj.submit();
           } // 
        }else if( operation === 'list' ){
           
           formObj
             .find("#bno")
                   .remove()
              .end()
             .attr("action", "/board/list")
             .submit();
           
           /*
           var pageNumTag = $("input[name=pageNum]").clone();
           var amountTag = $("input[name=amount]").clone();
           
           formObj
              .attr({
                     "action":"/board/list",
                     "method":"get"
                  })
               .empty()
               .append( pageNumTag )
               .append( amountTag )
               .submit();
           */
        } // if
     }); // click
  }); // ready
</script>
</body>
</html>

 --%>








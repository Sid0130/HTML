/**
 * 댓글 보기/감추기, 댓글 CRUD 요청/응답 처리.
 * post/details.jsp 파일에 포함.
 */

document.addEventListener('DOMContentLoaded', () => {
    // btnToggleComment 요소를 찾음.
    const btnToggleComment = document.querySelector('button#btnToggleComment');
    
    // div.collapseComments 요소를 부트스트랩의 Collapse 객체로 생성.
    const bsCollapse = new bootstrap.Collapse('div#collapseComments', {toggle : false});
    // 부트스트랩 컬립스 객체를 생성한다
    
    // btnToggleComment 버턴에 클릭 이벤트 리스너를 설정.
    btnToggleComment.addEventListener('click', ()=>{
       bsCollapse.toggle();
       // 생성이 되있는 컬립스 객체에서 클릭했을때 이벤트
       
       if(btnToggleComment.innerHTML === '댓글 보기'){
        btnToggleComment.innerHTML ='댓글 감추기';
       } else {
        btnToggleComment.innerHTML = '댓글 보기';
       }
    });

    
    // button#btnRegisterComment 요소를 찾음.
    const btnRegisterComment = document.querySelector('button#btnRegisterComment');
    
    // btnRegisterComment 버튼에 클릭 이벤트 리스너를 설정.
    btnRegisterComment.addEventListener('click', registerComment); 
    // 클릭했을때 함수의 이름. 클릭했을때 불러 올 함수(콜백)
    // 코드가 많이 엄청길 때 주로 사용된다.

    /* ---------------------- (콜백) 함수 선언 ------------------------- */
    /* 콜백 함수 선언 */
    
    // btnRegisterComment 버튼의 클릭 이벤트 리스너(콜백). 댓글 등록.
    // 클릭됬을때 호출되는 함수(콜백)
    function registerComment(){
        // input#id 요소의 값을 읽음 -> 댓글을 등록할 포스트의 아이디
        // CommentCreateDto의 id와 같은 변수이름
        const postId = document.querySelector('input#id').value; 
        // input#username 요소의 값을 읽음 -> 댓글 작성자 아이디
        const username = document.querySelector('input#username').value;
        // textara#ctext 요소의 값을 읽음 -> 댓글 내용
        const ctext = document.querySelector('textarea#ctext').value;
        
        // 댓글 내용이 비어 있는 지를 체크.
        if(ctext === ''){
            alert('댓글 내용을 입력하세요.'); // 내용이 비어 있으면 안되니까 창을 띄우고
            return; // 더 이상 진행하면 안되기 때문에 리턴.
        }
        
        // Ajax 요청으로 보낼 데이터 객체
//        const data = { postId:postId, username:username, ctext:ctext };
        const data = {postId, username, ctext}
        console.log(data);
                 // 필드이름 : 지역변수, 프로퍼티이름 : 값
                 // 자바스크립트는 중괄호는 객체, 대괄호는 배열
                 // 객체와지역변수 이름을 같이하면 간단하게 지역 변수이름 하나만 사용하면 됨.
                 // 지역변수의 값을 프로퍼티에 들어가게 됨.
                 // 객체를 만드는 방법.
                 
        // 서버로 POST 방식의 Ajax 요청을 보내고 응답을 처리. 라이브러리 사용. axios (JSP에 jsDelivr CDN 코드 넣기 )
        axios.post('../api/comment', data) // 요청을 보내는 주소, 요청을 보내는 데이터
                .then((response) => { // 이벤트리스너를 등록하는 코드 
                    //console.log(response);
                    if(response.data === 1){
                        alert('1개 댓글 등록 성공'); // 성공 확인 창
                        document.querySelector('textarea#ctext').value = ''; // 댓글 등록 후 텍스트에어리어 비우기
                    } // 프로퍼티를 찾는 방법은 로그를 출력하는 방법 밖에 없다. 프로퍼티를 쓰려면 . 
                    
                }) // 서버에서 HTTP 200 응답이 왔을 경우 실행할 콜백을 등록해주는 부분
                .catch((error) => { // 에러코드로 왔을 때 이벤트 리스너를 등록하는 코드
                    console.log(error);
                }); // 에러 응답이 왔을 경우(400, 500) 처리해야될 이벤트 콜백을 등록해주는 부분
                
                // http8080... / spring2/post/details? 
                // 현재위치의 폴더 = post ./ , spring2 = ../ spring2는 컨택스트 루트 . 값을 바꿀수 있기 때문에 상대경로로
                // 찾아가야지 안전하다. 자바 스크립트는 브라우저이기 때문에 브라우저는 지금 위치를 알고있고 ../ 두개로 
                
                // axios.post('../api/comment', data) 이 한줄로 요청 url을 서버로 보내는 것이고
                // 네트워크 페이로드에 소스보기는 클라이언트에서 서버로 보내는 실제 문자열. JSON 문자열
                // 요청을 보내고 나서 응답이 왔고 그 응답이 왔을때 리스펀스 로그를 출력을 해준것. 등록이 됬다는 것을 확인

        
    }
});
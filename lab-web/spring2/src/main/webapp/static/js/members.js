/**
 * username 중복체크, email 중복체크
 * user/signup.jsp 파일에 포함.
 */

document.addEventListener('DOMContentLoaded', () => {
    const inputUsername = document.querySelector('input#username');
    
    const checkUsernameResult = document.querySelector('div#checkUsernameResult');
    
    const inputPassword = document.querySelector('input#password');
    
    const inputEmail = document.querySelector('input#email');
    
    const checkEmailResult = document.querySelector('div#checkEmailResult');
    
    const btnSignUp = document.querySelector('button#signUp');
    
    // inputUsername 요소에 'change' 이벤트 리스너를 설정
    inputUsername.addEventListener('change', checkUsername);
    
    /* ----------------------- 함수 선언 ----------------------- */
    function checkUsername() {
        const username = inputUsername.value;
        if(username === ''){
            checkUsernameResult.innerHTML = '사용자 아이디는 필수 입력 항목입니다.';
            return;
        } 
        
        // 아이디 중복 체크 REST API(요청 URI)
        const uri = `./checkusername?username=${username}`;
        
        // Ajox 요청 보내기
        axios
        .get(uri)
        .then(handleCheckUsernameResp)
        .catch((error) => console.log(error));
//        alert('change');
    };
    
    
    function handleCheckUsernameResp({data}) { //아규먼트가 response
        
//        const {data} = response; //-> 구조분해 할당(destructuring assignment)
        // 배열과 오브젝트에서 사용할 수 있으며, 배열에서 사용하는 경우에는 
//        const arr = [1,2,3,4,5];
        //const x = arr[0];
        //const y = arr[1];
//        const [x,y] = arr; 
//        const [x,y, ...others] = arr; // ...others 는 나머지 연산자
//        console.log(x,y, others);
//        
//        const obj = {name:'홍길동', age:16 , phone: '1234-5678', email:'hgd'};
//        const {name, email, ...rest} = obj; // rest 는 프로퍼티 2개를 갖는 객체가 됨
//        console(name, email);
//        console(rest);
 
//        const obj = {name: '오쌤', age: 16};
////        const name = obj.name;
////        const age = obj.age;
//        const {name, age} = obj; // 구조분해 할당 지역변수 프로퍼티 이름과 같이 적어주면됨.
        console.log(data);

        if(data ==='Y'){
            checkUsernameResult.innerHTML = '멋진 아이디입니다.'
        } else {
            checkUsernameResult.innerHTML = '사용할 수 없는 아이디입니다.'
        }


    }
});
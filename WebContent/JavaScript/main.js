/**
 * 
 */

const toggleBtn = document.querySelector('.togglebtn');
const menu = document.querySelector('.menu_area');
const login = document.querySelector('.login_area');

toggleBtn.addEventListener('click', () => {
  menu.classList.toggle('active');
  login.classList.toggle('active');
});


//
//const slideBtn1 = document.querySelector('.slide_btn1');
//const slideBtn2 = document.querySelector('.slide_btn2');
//const slideBtn3 = document.querySelector('.slide_btn3');
//const slideBtn4 = document.querySelector('.slide_btn4');
//const slideArea = document.querySelector('.slide_area');
//
////for(var i = 1; i > 5; i++){
////	slideBtn+i.addEventListener('click',function(){
////		//버튼 2를 찾아서 클릭해주면 함수를 실행시켜라
////		slideArea.style.transform = 'translate((i-1)*(-100)vw)';
////		//해당 클래스의 태그에 transform 스타일을 적용 시켜라
////	});
////}
//
//slideBtn1.addEventListener('click',function(){
//	slideArea.style.transform = 'translate(0%)';
//});
//slideBtn2.addEventListener('click',function(){
//	slideArea.style.transform = 'translate(-100%)';
//});
//slideBtn3.addEventListener('click',function(){
//	slideArea.style.transform = 'translate(-200%)';
//});
//slideBtn4.addEventListener('click',function(){
//	slideArea.style.transform = 'translate(-300%)';
//});
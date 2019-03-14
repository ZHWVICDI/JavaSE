--1.插入用户信息
CREATE OR REPLACE PROCEDURE addUserdetails(uid userdetails.id%TYPE,
uname userdetails.username%TYPE,upwd  userdetails.password%TYPE,usex  userdetails.sex%TYPE DEFAULT 1)
IS 
BEGIN
	INSERT INTO userdetails(id,username,password,sex) VALUES(uid,uname,upwd,usex);
END;

--2.修改密码(函数有返回值)
CREATE OR REPLACE Function changePwd(uname userdetails.username%TYPE,upwd  userdetails.password%TYPE)
return  number
IS
BEGIN
  if upwd is null then
    return 0;
  else
    update userdetails set password = upwd where username = uname;
    return 1;
  end if;
END;

--3.获取用户总数（输出参数out）
CREATE OR REPLACE PROCEDURE getUserCount(num out number)
IS
BEGIN
	SELECT count(*) INTO num FROM userdetails ;
END;

--4.求两个数的和与差(使用输入输出参数 in out)
CREATE OR REPLACE PROCEDURE addSub(
num1 in out number,num2 in out number)
IS 
BEGIN
	num1 := num1+num2;
	num2 := num1-num2-num2;
END;

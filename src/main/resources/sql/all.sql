/**
 * member sql 쿼리문 모음
 */
/*member table*/
CREATE TABLE member(
	memberId varchar2(50) unique not null
	,password varchar2(50) not null
	,name varchar2(50) not null
	,email varchar2(80)
	,phoneNum varchar2(100)
	,memberNum varchar2(50) primary key
	,address varchar2(500)
	);

/*memberNum 전용 seq*/
CREATE SEQUENCE member_seq;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 

/*member 테스트 계정값*//
INSERT INTO member
	(
        memberId
        ,password
        ,name
        ,phonenum
        ,membernum
	)
	values
	(
	'ppl1177'
	,'wow210'
	,'신태관'
	,'010-2222-3333'
	,member_seq.nextval
	);
/*게시판 SQL쿼리*/
create table board (
	boardnum		number	primary key,		--글번호
	id				varchar2(20) not null,		--작성자 ID
	title			varchar2(100) not null,		--글제목
	content			varchar2(2000) not null,	--글내용
	inputdate		date	default sysdate,	--작성날짜,시간
	hits			number 	default 0,			--조회수
	originalfile	varchar2(200),				--첨부파일명 (원래 이름)
	savedfile		varchar2(100)				--첨부파일명 (실제 저장된 이름)
);

/*게시판 전용 sequence*/
CREATE SEQUENCE board_seq;
	
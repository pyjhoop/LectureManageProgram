-- TABLE DROP
DROP TABLE TB_STUDENTINFO;
DROP TABLE TB_INSTRUCTOR;
DROP TABLE TB_LECTURE;
DROP TABLE TB_MANAGER;
DROP TABLE TB_STUDENT;

-- SEQUENCE DROP
DROP SEQUENCE SEQ_INSTRUCTOR;
DROP SEQUENCE SEQ_MANAGER;
DROP SEQUENCE SEQ_STUDENT;
DROP SEQUENCE SEQ_LECNO;
DROP SEQUENCE SEQ_STUDENTINFO;

--강의 테이블 생성
CREATE TABLE TB_LECTURE(
    LECTURE_NO NUMBER CONSTRAINT PK_LECTURE PRIMARY KEY,
    LECTURE_TYPE VARCHAR2(20),
    LECTURE_NAME VARCHAR2(50) NOT NULL, 
    LECTURE_PRICE NUMBER NOT NULL,
    COURSETIME VARCHAR2(10) NOT NULL,
    DISCOUNT NUMBER DEFAULT 0 NOT NULL
);


-- TB_LECTURE 시퀀스 생성 (100부터 10증가)
CREATE SEQUENCE SEQ_LECNO
START WITH 100
INCREMENT BY 10
NOCACHE;


-- TB_LECTURE 코멘트 생성
COMMENT ON COLUMN TB_LECTURE.LECTURE_NO IS '강의번호';
COMMENT ON COLUMN TB_LECTURE.LECTURE_TYPE IS '강의타입';
COMMENT ON COLUMN TB_LECTURE.LECTURE_NAME IS '강의명';
COMMENT ON COLUMN TB_LECTURE.LECTURE_PRICE IS '강의가격';
COMMENT ON COLUMN TB_LECTURE.COURSETIME IS '수강시간';
COMMENT ON COLUMN TB_LECTURE.DISCOUNT IS '할인가';


-- TB_LECTURE 데이터 삽입
INSERT INTO TB_LECTURE VALUES(SEQ_LECNO.NEXTVAL, '수능', '언어와 매체', '110000', '70분', DEFAULT);
INSERT INTO TB_LECTURE VALUES(SEQ_LECNO.NEXTVAL, '수능', '확률과 통계', '150000', '100분', DEFAULT);
INSERT INTO TB_LECTURE VALUES(SEQ_LECNO.NEXTVAL, '수능', '수능 영어2', '140000', '85분', DEFAULT);
INSERT INTO TB_LECTURE VALUES(SEQ_LECNO.NEXTVAL, '수능', '한국사 20시간의 기적', '130000', '60분', DEFAULT);
INSERT INTO TB_LECTURE VALUES(SEQ_LECNO.NEXTVAL, '수능', '물리학1', '125000', '80분', DEFAULT);
INSERT INTO TB_LECTURE VALUES(SEQ_LECNO.NEXTVAL, '내신', '한국사 스피드', '80000', '60분', DEFAULT);
INSERT INTO TB_LECTURE VALUES(SEQ_LECNO.NEXTVAL, '내신', '수학1', '110000', '70분', DEFAULT);
INSERT INTO TB_LECTURE VALUES(SEQ_LECNO.NEXTVAL, '내신', '야너두', '80000', '100분', DEFAULT);
INSERT INTO TB_LECTURE VALUES(SEQ_LECNO.NEXTVAL, '내신', '달콤 완자 한국사', '130000', '65분', DEFAULT);
INSERT INTO TB_LECTURE VALUES(SEQ_LECNO.NEXTVAL, '내신', '통합과학 시작이반이다', '120000', '60분', DEFAULT);


-- 강사 테이블 생성
CREATE TABLE TB_INSTRUCTOR(
    INSTRUCTOR_NO NUMBER PRIMARY KEY,
    INSTRUCTOR_NAME VARCHAR2(30) NOT NULL,
    SALARY NUMBER NOT NULL,
    LECTURE_NO NUMBER REFERENCES TB_LECTURE ON DELETE SET NULL,
    RESIGNATION CHAR(6) DEFAULT '입사' CHECK(RESIGNATION IN('입사','퇴사')) 
);
-- 퇴사변경시 연봉 0으로 변경하는 트리거 생성
CREATE OR REPLACE TRIGGER TRG_INS
BEFORE UPDATE ON TB_INSTRUCTOR
FOR EACH ROW
DECLARE
BEGIN
    IF :NEW.RESIGNATION = '퇴사'
        THEN
            :NEW.SALARY := 0;
    END IF;
END;
/
-- 강사 컬럼에 대한 코멘트
COMMENT ON COLUMN TB_INSTRUCTOR.INSTRUCTOR_NO IS '강사번호';
COMMENT ON COLUMN TB_INSTRUCTOR.INSTRUCTOR_NAME IS '강사명';
COMMENT ON COLUMN TB_INSTRUCTOR.SALARY IS '연봉';
COMMENT ON COLUMN TB_INSTRUCTOR.LECTURE_NO IS '강의번호';
COMMENT ON COLUMN TB_INSTRUCTOR.RESIGNATION IS '입/퇴사여부';
-- 강사 번호에 대한 시퀀스 1부터 1씩 증가
CREATE SEQUENCE SEQ_INSTRUCTOR
NOCACHE;
-- 강사 데이터 삽입
INSERT INTO TB_INSTRUCTOR VALUES(SEQ_INSTRUCTOR.NEXTVAL,'고석용',60000000,130,'입사');
INSERT INTO TB_INSTRUCTOR VALUES(SEQ_INSTRUCTOR.NEXTVAL,'백호',72000000,150,'입사');
INSERT INTO TB_INSTRUCTOR VALUES(SEQ_INSTRUCTOR.NEXTVAL,'배기범',80000000,120,'입사');
INSERT INTO TB_INSTRUCTOR VALUES(SEQ_INSTRUCTOR.NEXTVAL,'박지향',75000000,110,'입사');
INSERT INTO TB_INSTRUCTOR VALUES(SEQ_INSTRUCTOR.NEXTVAL,'강민철',90000000,100,'입사');
INSERT INTO TB_INSTRUCTOR VALUES(SEQ_INSTRUCTOR.NEXTVAL,'전형태',64000000,160,'입사');
INSERT INTO TB_INSTRUCTOR VALUES(SEQ_INSTRUCTOR.NEXTVAL,'양승진',88000000,190,'입사');
INSERT INTO TB_INSTRUCTOR VALUES(SEQ_INSTRUCTOR.NEXTVAL,'김기현',92000000,120,'입사');
INSERT INTO TB_INSTRUCTOR VALUES(SEQ_INSTRUCTOR.NEXTVAL,'김지영',77000000,110,'입사');
INSERT INTO TB_INSTRUCTOR VALUES(SEQ_INSTRUCTOR.NEXTVAL,'김엄지',98000000,130,'입사');
-- 매니저 테이블 생성
CREATE TABLE TB_MANAGER(
    MANAGER_NO NUMBER PRIMARY KEY,
    MANAGER_NAME VARCHAR2(30) NOT NULL,
    MANAGER_ID VARCHAR2(30) UNIQUE NOT NULL,
    MANAGER_PWD VARCHAR2(30) NOT NULL
);
-- 매니저 컬럼에 대한 코멘트 
COMMENT ON COLUMN TB_MANAGER.MANAGER_NO IS '관리자 번호';
COMMENT ON COLUMN TB_MANAGER.MANAGER_NAME IS '관리자 이름';
COMMENT ON COLUMN TB_MANAGER.MANAGER_ID IS '관리자 아이디';
COMMENT ON COLUMN TB_MANAGER.MANAGER_PWD IS '관리자 비밀번호';

-- 매니저 번호에 대한 시퀀스 1부터 1씩 증가
CREATE SEQUENCE SEQ_MANAGER
NOCACHE;
-- 매니저 데이터 삽입
INSERT INTO TB_MANAGER VALUES(SEQ_MANAGER.NEXTVAL,'강인호', 'kang0022', 'inho789');
INSERT INTO TB_MANAGER VALUES(SEQ_MANAGER.NEXTVAL,'박연준', 'park5522', 'Yeonjun123');
INSERT INTO TB_MANAGER VALUES(SEQ_MANAGER.NEXTVAL,'조진원', 'Jo9911', 'Jinwon456');


-- TB_STUDENT 생성
CREATE TABLE TB_STUDENT(
    STU_NO NUMBER CONSTRAINT PK_STU_NO PRIMARY KEY,
    STU_NAME VARCHAR2(30) CONSTRAINT NN_STU_NAME NOT NULL -- NAME으로 수정
);

-- TB_STUDENT COMMENT 달아주기
COMMENT ON COLUMN TB_STUDENT.STU_NO IS '학생번호';
COMMENT ON COLUMN TB_STUDENT.STU_NAME IS '학생이름';

-- TB_STUDENT에 필요한 SEQUENCE 생성
CREATE SEQUENCE SEQ_STUDENT
NOCYCLE
NOCACHE;

-- TB_STUDENT에 값 10개 추가
INSERT INTO TB_STUDENT VALUES(SEQ_STUDENT.NEXTVAL, '권유준');
INSERT INTO TB_STUDENT VALUES(SEQ_STUDENT.NEXTVAL, '최상욱');
INSERT INTO TB_STUDENT VALUES(SEQ_STUDENT.NEXTVAL, '송수현');
INSERT INTO TB_STUDENT VALUES(SEQ_STUDENT.NEXTVAL, '심명선');
INSERT INTO TB_STUDENT VALUES(SEQ_STUDENT.NEXTVAL, '조형남');
INSERT INTO TB_STUDENT VALUES(SEQ_STUDENT.NEXTVAL, '유도영');
INSERT INTO TB_STUDENT VALUES(SEQ_STUDENT.NEXTVAL, '남연주');
INSERT INTO TB_STUDENT VALUES(SEQ_STUDENT.NEXTVAL, '박세희');
INSERT INTO TB_STUDENT VALUES(SEQ_STUDENT.NEXTVAL, '황희재');
INSERT INTO TB_STUDENT VALUES(SEQ_STUDENT.NEXTVAL, '백경석');



-- TB_SUTUDENTINFO 만들기
CREATE TABLE TB_STUDENTINFO(
    STUINFO_NO NUMBER CONSTRAINT PK__STUINFO_NO PRIMARY KEY,
    STU_ID VARCHAR2(30) CONSTRAINT NN_STU_ID NOT NULL UNIQUE, -- ID로 바꿈 UNIQUE추가
    STU_AGE NUMBER CONSTRAINT NN_STU_AGE NOT NULL,
    GENDER CHAR(3) CONSTRAINT CK_GENDER CHECK(GENDER IN('M','F')),
    PHONE VARCHAR2(14) CONSTRAINT NN_PHONE NOT NULL UNIQUE, -- UNIQUE 추가
    STU_NO NUMBER CONSTRAINT FK_STU_NO REFERENCES TB_STUDENT UNIQUE, -- UNIQUE 추가 중복되면 안되니깐
    LECTURE_NO NUMBER CONSTRAINT FK_LEC_NO REFERENCES TB_LECTURE ON DELETE SET NULL
);


-- TB_STUDENTINFO COMMENT 달기
COMMENT ON COLUMN TB_STUDENTINFO.STUINFO_NO IS '학생정보 번호';
COMMENT ON COLUMN TB_STUDENTINFO.STU_ID IS '학생 아이디';
COMMENT ON COLUMN TB_STUDENTINFO.STU_AGE IS '학생 나이';
COMMENT ON COLUMN TB_STUDENTINFO.GENDER IS '성별';
COMMENT ON COLUMN TB_STUDENTINFO.PHONE IS '학생 전화번호';
COMMENT ON COLUMN TB_STUDENTINFO.STU_NO IS '학생 번호';
COMMENT ON COLUMN TB_STUDENTINFO.LECTURE_NO IS '강의 번호';

-- SEQ_STUDENTINFO 만들기
CREATE SEQUENCE SEQ_STUDENTINFO
START WITH 1000
NOCACHE
NOCYCLE;


--TB_STUDENTINFO 값 10개 추가하기
INSERT INTO TB_STUDENTINFO VALUES(SEQ_STUDENTINFO.NEXTVAL,'iahls98f',23,'M','01023123453',1,110);
INSERT INTO TB_STUDENTINFO VALUES(SEQ_STUDENTINFO.NEXTVAL,'wnymr0gc',41,'M','01046643421',2,130);
INSERT INTO TB_STUDENTINFO VALUES(SEQ_STUDENTINFO.NEXTVAL,'lkbehqgm',34,'F','01023128768',3,170);
INSERT INTO TB_STUDENTINFO VALUES(SEQ_STUDENTINFO.NEXTVAL,'buji09wo',45,'F','01088765534',4,120);
INSERT INTO TB_STUDENTINFO VALUES(SEQ_STUDENTINFO.NEXTVAL,'plsmnuuj',51,'M','01023348857',5,110);
INSERT INTO TB_STUDENTINFO VALUES(SEQ_STUDENTINFO.NEXTVAL,'enafijpm',21,DEFAULT,'01023488653',6,140);
INSERT INTO TB_STUDENTINFO VALUES(SEQ_STUDENTINFO.NEXTVAL,'Kahlsf',29,'F','01088649864',7,150);
INSERT INTO TB_STUDENTINFO VALUES(SEQ_STUDENTINFO.NEXTVAL,'tkhteiaw',19,'M','01023876579',8,160);
INSERT INTO TB_STUDENTINFO VALUES(SEQ_STUDENTINFO.NEXTVAL,'fosqswzf',32,'F','01067478744',9,180);
INSERT INTO TB_STUDENTINFO VALUES(SEQ_STUDENTINFO.NEXTVAL,'akxfpclt',26,'M','01010041004',10,190);

COMMIT;


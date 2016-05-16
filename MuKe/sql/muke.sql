--�����û��Լ���Ȩ��
create user muke identified by a;
grant resource,connect to vote;

--����Ա��
drop table admin;
drop sequence seq_admin_aId;

create table admin(
       aId varchar2(20) primary key,          --����Ա���
       aName varchar2(20) not null,           --����Ա����
       aPwd varchar2(20) not null,            --����Ա����
       aRetain1 varchar2(100),                --�����ֶ� 
       aRetain2 varchar2(100),                --�����ֶ�
       aRetain3 varchar2(100),                --�����ֶ�
       aStatus int                            --ɾ�����  0�ѱ�ɾ�� 1Ϊ����
                constraint CK_admin_aStatus check(aStatus in(1,2))
)

create sequence seq_admin_aId
       START WITH 1000    -- ��1000��ʼ���� 
       INCREMENT BY 1     -- ÿ�μ�1��

insert into admin values(0,'a','a','','','',1);
select * from  admin;
select * from admin where aName='a' and aPwd='a'


--�û���Ϣ��
drop table users;
drop sequence seq_users_uNo;

create table users(
       uNo varchar(20) primary key,         --�û����
       uName varchar2(20) not null,         --�û���
       uPwd varchar2(20) not null,          --�û�����
       uAddress_prov varchar2(50),          --ʡ
       uAddress_city varchar2(50),          --��
       uAddress_county varchar2(50),        --��
       uSex varchar2(20) default '��'       --�Ա�
              constraint CK_users_uSex check(uSex in('��','Ů')),
       uUsign varchar2(200),                --����ǩ��
       uPic varchar2(200),                  --ͷ��
       uTel varchar2(20),                   --�ֻ�
       uIsTeacher int,                      --0��ʾ���ǽ�ʦ 1��ʾΪ�ǽ�ʦ
       uStudytime int,                      --ѧϰʱ��
       uRetain1 varchar2(100),              --�����ֶ� 
       uRetain2 varchar2(100),              --�����ֶ�
       uRetain3 varchar2(100),              --�����ֶ�
       uStatus int                          --ɾ�����  0�ѱ�ɾ�� 1Ϊ����
               constraint CK_users_uStatus check(uStatus in(1,2))
)

create sequence seq_users_uNo
       START WITH 1000    -- ��1000��ʼ���� 
       INCREMENT BY 1     -- ÿ�μ�1��

select * from users;


--�γ�����
drop table ctype;
drop sequence seq_ctype_ctNo;

create table ctype(
       ctNo varchar2(20) primary key,   --�����
       ctName varchar2(20) not null,    --�����
       ctDirname varchar2(20) not null, --��������
       ctRetain1 varchar2(100),         --�����ֶ� 
       ctRetain2 varchar2(100),         --�����ֶ�
       ctRetain3 varchar2(100),         --�����ֶ�
       ctStatus int                     --ɾ�����  0�ѱ�ɾ�� 1Ϊ����
              constraint CK_ctype_ctStatus check(ctStatus in(1,2))
)

create sequence seq_ctype_ctNo
       START WITH 1000    -- ��1000��ʼ���� 
       INCREMENT BY 1     -- ÿ�μ�1��

select * from ctype;


--�γ����ױ�
drop table deeply;
drop sequence seq_deeply_dNo;

create table deeply(
       dNo varchar2(20) primary key,       --���׶ȱ��
       dName varchar2(15) not null unique, --���׶�����
       dRetain1 varchar2(100),             --�����ֶ� 
       dRetain2 varchar2(100),             --�����ֶ�
       dRetain3 varchar2(100),             --�����ֶ�
       dStatus int                         --ɾ�����  0�ѱ�ɾ�� 1Ϊ����
              constraint CK_deeply_dStatus check(dStatus in(1,2))
)

create sequence seq_deeply_dNo
       START WITH 1000    -- ��1000��ʼ���� 
       INCREMENT BY 1    -- ÿ�μ�1��
       
select * from deeply;


--�γ���Ϣ��(course)
drop table course;
drop sequence seq_course_cNo;

create table course(
      cNo varchar2(20) primary key,       --�γ̱��
      cName varchar2(25) not null unique, --�γ���
      dNo varchar2(20)                    --���׶�
                constraint FK_course_dNo references deeply(dNo),
      ctNo varchar2(20)                   --���
                constraint FK_course_ctNo references ctype(ctNo),
      cUpdatetime varchar2(20),           --����ʱ��
      cUpstatus int                      --�Ƿ���� 0���� 1δ����
                constraint CK_course_cUpstatus check(cUpstatus in(1,2)),
      cPic varchar2(100),                 --�γ�ͼƬ��·��
      cRetain1 varchar2(100),             --�����ֶ� 
      cRetain2 varchar2(100),             --�����ֶ�
      cRetain3 varchar2(100),             --�����ֶ�
      cStatus int                         --ɾ�����  0�ѱ�ɾ�� 1Ϊ����
                constraint CK_course_cStatus check(cStatus in(1,2))
)

create sequence seq_course_cNo
       START WITH 1000    -- ��1000��ʼ���� 
       INCREMENT BY 1     -- ÿ�μ�1��

select * from course;


--�û�ѧϰ�Ŀγ̱�
drop table ucourse;

create table ucourse(
       uNo varchar2(20)                      --�û�
                constraint FK_ucourse_uno references users(uNo),
       cNo varchar2(20)                      --�γ�
                constraint FK_ucourse_cno references course(cNo),
       ucAttention int                     --1��ʾ�ѹ�ע��0��ʾδ��ע
                constraint CK_ucourse_ucAttention check(ucAttention in(1,2)),
       ucLearnstatus int                    --ѧϰ״̬ 1����ѧ 0��ѧ��
                constraint CK_ucourse_ucLearnstatus check(ucLearnstatus in(1,2)),
       ucNowChNo varchar2(100),        --����ѧϰ�����½���
       ucRetain1 varchar2(100),              --�����ֶ� 
       ucRetain2 varchar2(100),              --�����ֶ�
       ucRetain3 varchar2(100),              --�����ֶ�
       ucStatus int                          --ɾ�����  0�ѱ�ɾ�� 1Ϊ����
                constraint CK_ucourse_ucStatus check(ucStatus in(1,2))
)

select * from (select a.*,rownum rn from (select r.*,uname,cname,cpic,updatetime from ucourse r, course d,users e where r.status!=0 and r.uno=e.uno and r.cno=d.cno and r.attention=1 and r.uno=1000 order by r.uno) a where rownum<=5) b where rn>0;
select * from ucourse;

--�½����ͱ�
drop table chapter;
drop sequence seq_chapter_chapterno;

create table chapter(
       chNo varchar2(20) primary key,            --�½ڱ��
       chName varchar2(200) not null,            --�½���
       cNo varchar2(20)                          --�γ�
              constraint FK_chapter_cNo references course(cNo),
       chContent varchar(200),                   --�½�����
       chOrder int,                              --�½ڵ�˳��
       chRetain1 varchar2(100),                  --�����ֶ� 
       chRetain2 varchar2(100),                  --�����ֶ�
       chRetain3 varchar2(100),                  --�����ֶ�
       chStatus int                              --ɾ�����  0�ѱ�ɾ�� 1Ϊ����
              constraint CK_chapter_chStatus check(chStatus in(1,2))
)

create sequence seq_chapter_chNo
       START WITH 1000    -- ��1000��ʼ���� 
       INCREMENT BY 1     -- ÿ�μ�1��

select * from chapter;


--���۱�
drop table comments;
drop sequence seq_comments_coNo;

create table comments(
       coNo varchar2(20) primary key,        --���۱��
       uNo varchar2(20)                      --�û�
           constraint FK_comments_uNo references users(uNo),
       chNo varchar2(20)                     --�½�
           constraint FK_comments_chNo references chapter(chNo),
       coContent clob,                       --��������
       coTime varchar2(200),                          --����ʱ��
       coDianzannum int,                     --������
       coPic varchar2(200),                  --���۽�ͼ
       coRetain1 varchar2(100),              --�����ֶ� 
       coRetain2 varchar2(100),              --�����ֶ�
       coRetain3 varchar2(100),              --�����ֶ�
       coStatus int                          --ɾ�����  0�ѱ�ɾ�� 1Ϊ����
           constraint CK_comments_coStatus check(coStatus in(1,2))
)

create sequence seq_comments_coNo
       START WITH 1000    -- ��1000��ʼ���� 
       INCREMENT BY 1    -- ÿ�μ�1��
       
select * from comments;

--�����
drop table ask;
drop sequence seq_ask_aNo;

create table ask(
       aNo varchar2(20) primary key,       --�ʴ���
       ctNo varchar2(50)                   --����
           constraint FK_ask_ctNo references ctype(ctNo),
       uNo varchar2(20)                    --������
           constraint FK_ask_uNo references users(uNo),
       aTitle varchar2(50),                 --�������
       aContent clob,                       --��������
       aTime varchar2(200),              --����ʱ��
       aRetain1 varchar2(100),              --�����ֶ� 
       aRetain2 varchar2(100),              --�����ֶ�
       aRetain3 varchar2(100),              --�����ֶ�
       aStatus int                          --ɾ�����  0�ѱ�ɾ�� 1Ϊ����
           constraint CK_ask_aStatus check(aStatus in(1,2))   
)

create sequence seq_ask_aNo
       START WITH 1000    -- ��1000��ʼ���� 
       INCREMENT BY 1    -- ÿ�μ�1��
       
select * from ask;


--�ش��
drop table answer;
drop sequence seq_ask_aNo;

create table answer(
       anNo varchar2(20) primary key,              --�ش���
       aNo varchar2(20)                          --����
           constraint FK_answer_aNo references ask(aNo),
       anContent clob,                         --�ش�����
       uNo varchar2(20)                            --�ش���
           constraint FK_answer_uno references users(uNo),
       anTime varchar2(200),                   --�ش�ʱ��
       anRetain1 varchar2(100),                    --�����ֶ� 
       anRetain2 varchar2(100),                    --�����ֶ�
       anRetain3 varchar2(100),                    --�����ֶ�
       anStatus int                                --ɾ�����  0�ѱ�ɾ�� 1Ϊ����
           constraint CK_ask_anStatus check(anStatus in(1,2))      
)

create sequence seq_ask_aNo
       START WITH 1000    -- ��1000��ʼ���� 
       INCREMENT BY 1     -- ÿ�μ�1��
       
select * from answer;


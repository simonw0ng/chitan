drop table if exists t_user;

CREATE TABLE t_user (
  ID bigint(18) DEFAULT NULL COMMENT '�û�ID',
  LOGIN_NAME varchar(32) DEFAULT NULL COMMENT '��½����',
  PASSWORD varchar(32) DEFAULT NULL COMMENT '��½����'
) ENGINE=InnoDB DEFAULT CHARSET=utf8
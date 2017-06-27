-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS "public"."users";
CREATE TABLE "public"."users" (
"id" int4 DEFAULT nextval('users_id_seq'::regclass) NOT NULL,
"username" varchar(100) COLLATE "default",
"gender" varchar(10) COLLATE "default",
"phonenumber" varchar(20) COLLATE "default",
"email" varchar(100) COLLATE "default",
"status" varchar(1) COLLATE "default",
"created_date" timestamp(6),
"user_hash" varchar(100) COLLATE "default"
)
WITH (OIDS=FALSE)
;

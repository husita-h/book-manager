# メモ

---

# データベースの作成

## スクリプト
MYSQL
`mysql -h 127.0.0.1 --port 3306 -uroot -pmysql`

### データベースの作成
```mysql
create database book_manager;
```

`use book_manager;`

### テーブルを作成
```mysql
CREATE TABLE user (
    id bigint NOT NUll,
    email varchar(128) NOT NULL,
    password varchar(128) NOT NULL,
    name varchar(32) NOT NULL,
    role_type enum("ADMIN", "USER"),
    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE book (
    id bigint NOT NUll,
    title varchar(128) NOT NULL,
    author varchar(128) NOT NULL,
    release_date date NOT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE rental (
    book_id bigint NOT NUll,
    user_id varchar(128) NOT NULL,
    rental_datetime varchar(128) NOT NULL,
    return_deadline datetime NOT NULL,
    PRIMARY KEY(book_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

### テストデータの挿入
```mysql
insert into book values(100, "Kotlin入門", "コトリン太郎", "1950-10-01"), (200, "JAVA入門", "ジャバ次郎", "2000-08-29");

insert into user values(1, "admin@test.com", "adminadmin", "管理者", "ADMIN"), (2, "user@test.com", "useruser", "ユーザー", "USER");
```

---

# ビルドに失敗する
```
Could not open init generic class cache for initialization script '/private/var/folders/kf/0y142yvn13d1h2yzcsy6ls280000gn/T/wrapper_init5.gradle' (/Users/tfukushi/.gradle/caches/6.9/scripts/ck034wklczs64xkn54a0k6pbt).
> BUG! exception in phase 'semantic analysis' in source unit '_BuildScript_' Unsupported class file major version 61

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.
```

## [解決法]Gradle JVMのバージョンを下げる

- 変更前
  - `coretto-17`
- 変更後
  - `jvr-11`
- <img width="1160" alt="スクリーンショット 2022-06-21 1 23 46" src="https://user-images.githubusercontent.com/71882104/174645528-1544fa04-5642-4fc0-b419-b26af09ff09e.png">

# MySQLへログイン
`mysql -h 127.0.0.1 --port 3306 -u root -p mysql`

## コマンドオプション
https://dev.mysql.com/doc/refman/5.6/ja/mysql-command-options.html
- `-h` or `--host`
  - 指定されたホストの MySQL サーバーに接続します。
- `-uroot` or `--user=root`
  - サーバーへの接続時に使用する MySQL ユーザー名。
  - rootユーザーでログイン
- `-p` or `--password`
  - サーバーに接続する際に使用するパスワードです。短いオプション形式 (-p) を使用した場合は、オプションとパスワードの間にスペースを置くことはできません。コマンド行で、--password オプションまたは -p オプションに続けて password の値を指定しなかった場合、mysql はそれを要求します。


# アノテーション





# データベースの作成

## スクリプト
MYSQL
`mysql -h 127.0.0.1 --port 3306 -uroot -pmysql`

データベースの作成
```mysql
create database book_manager
```

`use book_manager`

```mysql
CREATE TABLE USER (
    id bigint NOT NUll,
    email varchar(128) NOT NULL,
    password varchar(128) NOT NULL,
    name varchar(32) NOT NULL,
    role_type enum("ADMIN", "USER"),
    PRIMARY KEY(id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE book (
    id bigint NOT NUll,
    title varchar(128) NOT NULL,
    author varchar(128) NOT NULL,
    release_date date NOT NULL,
    PRIMARY KEY(id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE rental (
    book_id bigint NOT NUll,
    user_id varchar(128) NOT NULL,
    rental_datetime varchar(128) NOT NULL,
    return_deadline datetime NOT NULL,
    PRIMARY KEY(book_id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```


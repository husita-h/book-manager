package com.bookmanager.infrastructure.database.record.custom

import com.bookmanager.infrastructure.database.mapper.BookDynamicSqlSupport
import com.bookmanager.infrastructure.database.mapper.BookDynamicSqlSupport.Book.author
import com.bookmanager.infrastructure.database.mapper.BookDynamicSqlSupport.Book.id
import com.bookmanager.infrastructure.database.mapper.BookDynamicSqlSupport.Book.releaseDate
import com.bookmanager.infrastructure.database.mapper.BookDynamicSqlSupport.Book.title
import com.bookmanager.infrastructure.database.mapper.RentalDynamicSqlSupport
import com.bookmanager.infrastructure.database.mapper.RentalDynamicSqlSupport.Rental.rentalDatetime
import com.bookmanager.infrastructure.database.mapper.RentalDynamicSqlSupport.Rental.returnDeadline
import com.bookmanager.infrastructure.database.mapper.RentalDynamicSqlSupport.Rental.userId
import org.mybatis.dynamic.sql.SqlBuilder.equalTo
import org.mybatis.dynamic.sql.SqlBuilder.select
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.from

private val columnList = listOf(
    id,
    title,
    author,
    releaseDate,
    userId,
    rentalDatetime,
    returnDeadline
)

//BookWithRentalMapperの関数を使用して、クエリを生成せして実行する拡張関数を定義したファイル
//bookテーブルとrentalテーブルをjoinしてデータを取得するクエリを生成する処理を定義
//select(columnList)でselect句を指定
//columnListははテーブルごとに生成されているカラムの情報の定義
//BookDynamicSqlSupportとRentalDynamicSqlSupportのobjectに定義されているフィールドを参照して、Listにしている

//mybatis dynamic sqlを使うことで、関数をチェーン、ネストすることでsqlのクエリを実行できるようになる
fun BookWithRentalMapper.select(): List<BookWithRentalRecord> {

    val selectStatement = select(columnList).from(BookDynamicSqlSupport.Book, "b") {
        leftJoin(RentalDynamicSqlSupport.Rental, "r") {
            on(BookDynamicSqlSupport.Book.id, equalTo(RentalDynamicSqlSupport.Rental.bookId))
        }
    }
    return selectMany(selectStatement)
}


package com.bookmanager.infrastructure.database.record.custom

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter

@Mapper
interface BookWithRentalMapper {
    //SqlProviderAdapterクラスのselectメソッドを使用してクエリを生成する
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    //id属性には任意の文字列を指定
    //value属性にはResultアノテーションを使い、
    //columnで指定した値を、propertyで設定したプロパティに設定したオブジェクトを取得できる
    @Results(
        id = "BookWithRentalRecordResult", value = [
            Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            Result(column = "author", property = "author", jdbcType = JdbcType.VARCHAR),
            Result(column = "release_date", property = "releaseDate", jdbcType = JdbcType.DATE),
            Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            Result(column = "rental_datetime", property = "rentalDatetime", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "return_deadline", property = "returnDeadline", jdbcType = JdbcType.TIMESTAMP)
        ]
    )
    //関数名は任意
    //自動生成のMapperにあわせてこの名前にしている
    //引数に渡している`SqlProviderAdapter`型の値は、
    fun selectMany(selectStatement: SelectStatementProvider): List<BookWithRentalRecord>
}

package com.nickcassandra.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Student {

    @Id
    @PrimaryKeyColumn(name = "student_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Long studentId;

    @Column("first_name")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String firstName;

    @Column("last_name")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String lastName;

    @Column("email")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String email;
}

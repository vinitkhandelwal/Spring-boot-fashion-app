package com.ecommerce.fashionrent.config;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ArrayUserType implements UserType {

    public static final String HIBERNATE_TYPE_NAME = "arrayusertype";
    public static final ArrayUserType INSTANCE = new ArrayUserType();

    public int[] sqlTypes() {
        return new int[]{Types.ARRAY};
    }

    public Class<List> returnedClass() {
        return List.class;
    }

    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x, y);
    }

    public int hashCode(Object x) throws HibernateException {
        return x == null ? 0 : x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
            throws HibernateException, SQLException {

        if (names != null && names.length > 0 && rs != null && rs.getArray(names[0]) != null) {

            Object[] array = (Object[]) rs.getArray(names[0]).getArray();

            List<Object> list = new ArrayList<>();
            Collections.addAll(list, array);

            return list;
        }

        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        // does not seem to be needed just for getting an array from db
        throw new UnsupportedOperationException();
    }

    public Object deepCopy(Object value) throws HibernateException {
        // does not seem to be needed just for getting an array from db
        throw new UnsupportedOperationException();
    }

    public boolean isMutable() {
        return false;
    }

    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }
}
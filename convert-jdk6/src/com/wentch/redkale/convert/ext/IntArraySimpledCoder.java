/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wentch.redkale.convert.ext;

import com.wentch.redkale.convert.Reader;
import com.wentch.redkale.convert.SimpledCoder;
import com.wentch.redkale.convert.Writer;

/**
 *
 * @author zhangjx
 * @param <R>
 * @param <W>
 */
public final class IntArraySimpledCoder<R extends Reader, W extends Writer> extends SimpledCoder<R, W, int[]> {

    public static final IntArraySimpledCoder instance = new IntArraySimpledCoder();

    @Override
    public void convertTo(W out, int[] values) {
        if (values == null) {
            out.writeNull();
            return;
        }
        out.writeArrayB(values.length);
        boolean flag = false;
        for (int v : values) {
            if (flag) out.writeArrayMark();
            out.writeInt(v);
            flag = true;
        }
        out.writeArrayE();
    }

    @Override
    public int[] convertFrom(R in) {
        int len = in.readArrayB();
        if (len == Reader.SIGN_NULL) {
            return null;
        } else if (len == Reader.SIGN_NOLENGTH) {
            int size = 0;
            int[] data = new int[8];
            while (in.hasNext()) {
                if (size >= data.length) {
                    int[] newdata = new int[data.length + 4];
                    System.arraycopy(data, 0, newdata, 0, size);
                    data = newdata;
                }
                data[size++] = in.readInt();
            }
            in.readArrayE();
            int[] newdata = new int[size];
            System.arraycopy(data, 0, newdata, 0, size);
            return newdata;
        } else {
            int[] values = new int[len];
            for (int i = 0; i < values.length; i++) {
                values[i] = in.readInt();
            }
            in.readArrayE();
            return values;
        }
    }

}

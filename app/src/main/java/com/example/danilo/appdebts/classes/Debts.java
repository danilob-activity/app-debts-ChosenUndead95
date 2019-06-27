package com.example.danilo.appdebts.classes;

import java.util.Date;

/**
 * Created by aluno on 27/06/19.
 */

public class Debts {
    private long mId;
    private int mCodCat;
    private float mReal;
    private String descricao;
    private Date mDataVencimento;
    private Date mDataPagamento;

    public Debts(int mId, int mCodCat, float mReal, String descricao, Date mDataVencimento, Date mDataPagamento) {
        this.mId = mId;
        this.mCodCat = mCodCat;
        this.mReal = mReal;
        this.descricao = descricao;
        this.mDataVencimento = mDataVencimento;
        this.mDataPagamento = mDataPagamento;
    }

    public long getId() {
        return mId;
    }

    public int getmCodCat() {
        return mCodCat;
    }

    public float getmReal() {
        return mReal;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getmDataVencimento() {
        return mDataVencimento;
    }

    public Date getmDataPagamento() {
        return mDataPagamento;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public void setmCodCat(int mCodCat) {
        this.mCodCat = mCodCat;
    }

    public void setmReal(float mReal) {
        this.mReal = mReal;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setmDataVencimento(Date mDataVencimento) {
        this.mDataVencimento = mDataVencimento;
    }

    public void setmDataPagamento(Date mDataPagamento) {
        this.mDataPagamento = mDataPagamento;
    }
}

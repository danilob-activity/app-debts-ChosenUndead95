package com.example.danilo.appdebts.classes;

import java.util.Date;

/**
 * Created by aluno on 27/06/19.
 */

public class Debts {
    private long mId;
    private int mCodCat;
    private float mValor;
    private String descricao;
    private String mDataVencimento;
    private String mDataPagamento;

    public Debts() {
    }

    public Debts(int mId, int mCodCat, float mReal, String descricao, String mDataVencimento, String mDataPagamento) {
        this.mId = mId;
        this.mCodCat = mCodCat;
        this.mValor = mReal;
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

    public float getValor() {
        return mValor;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataVencimento() {
        return mDataVencimento;
    }

    public String getDataPagamento() {
        return mDataPagamento;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public void setCodCat(int mCodCat) {
        this.mCodCat = mCodCat;
    }

    public void setValor(float mValor) {
        this.mValor = mValor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataVencimento(String mDataVencimento) {
        this.mDataVencimento = mDataVencimento;
    }

    public void setDataPagamento(String mDataPagamento) {
        this.mDataPagamento = mDataPagamento;
    }
}

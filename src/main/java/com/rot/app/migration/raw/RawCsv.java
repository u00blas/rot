package com.rot.app.migration.raw;

import jakarta.persistence.*;

@Entity
@Table(name = "raw_csv")
public class RawCsv {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "raw_data", columnDefinition = "TEXT")
    private String rawData;
    @Column(name = "balanced_data", columnDefinition = "TEXT")
    private String balancedData;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    @Column(name = "w", columnDefinition = "TEXT")
    private String w;
    private String x;
    private String y;
    private String z;
    private String aa;
    private String ab;
    private String ac;
    private String ad;
    private String ae;
    private String af;
    private String ag;
    private String ah;
    private String ai;
    private String aj;
    private String ak;
    private String al;
    private String am;
    private String an;
    private String ao;
    private String ap;
    private String aq;
    private String ar;
    private String tas;
    private String at;
    private String au;
    private String av;
    private String aw;
    private String ax;
    private String ay;
    private String az;
    private String ba;
    private String bb;
    private String bc;
    private String bd;
    private String be;
    private String bf;
    private String bg;
    private String bh;
    private String bi;
    private String bj;
    private String bk;
    private String bl;
    private String bm;
    private String bn;

    public RawCsv() {
    }

    public RawCsv(Long id, String rawData, String balancedData, String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k, String l, String m, String n, String o, String p, String q, String r, String s, String t, String u, String v, String w, String x, String y, String z, String aa, String ab, String ac, String ad, String ae, String af, String ag, String ah, String ai, String aj, String ak, String al, String am, String an, String ao, String ap, String aq, String ar, String tas, String at, String au, String av, String aw, String ax, String ay, String az, String ba, String bb, String bc, String bd, String be, String bf, String bg, String bh, String bi, String bj, String bk, String bl, String bm, String bn) {
        this.id = id;
        this.rawData = rawData;
        this.balancedData = balancedData;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
        this.o = o;
        this.p = p;
        this.q = q;
        this.r = r;
        this.s = s;
        this.t = t;
        this.u = u;
        this.v = v;
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
        this.aa = aa;
        this.ab = ab;
        this.ac = ac;
        this.ad = ad;
        this.ae = ae;
        this.af = af;
        this.ag = ag;
        this.ah = ah;
        this.ai = ai;
        this.aj = aj;
        this.ak = ak;
        this.al = al;
        this.am = am;
        this.an = an;
        this.ao = ao;
        this.ap = ap;
        this.aq = aq;
        this.ar = ar;
        this.tas = tas;
        this.at = at;
        this.au = au;
        this.av = av;
        this.aw = aw;
        this.ax = ax;
        this.ay = ay;
        this.az = az;
        this.ba = ba;
        this.bb = bb;
        this.bc = bc;
        this.bd = bd;
        this.be = be;
        this.bf = bf;
        this.bg = bg;
        this.bh = bh;
        this.bi = bi;
        this.bj = bj;
        this.bk = bk;
        this.bl = bl;
        this.bm = bm;
        this.bn = bn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getBalancedData() {
        return balancedData;
    }

    public void setBalancedData(String balancedData) {
        this.balancedData = balancedData;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public String getJ() {
        return j;
    }

    public void setJ(String j) {
        this.j = j;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getAb() {
        return ab;
    }

    public void setAb(String ab) {
        this.ab = ab;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAe() {
        return ae;
    }

    public void setAe(String ae) {
        this.ae = ae;
    }

    public String getAf() {
        return af;
    }

    public void setAf(String af) {
        this.af = af;
    }

    public String getAg() {
        return ag;
    }

    public void setAg(String ag) {
        this.ag = ag;
    }

    public String getAh() {
        return ah;
    }

    public void setAh(String ah) {
        this.ah = ah;
    }

    public String getAi() {
        return ai;
    }

    public void setAi(String ai) {
        this.ai = ai;
    }

    public String getAj() {
        return aj;
    }

    public void setAj(String aj) {
        this.aj = aj;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getAl() {
        return al;
    }

    public void setAl(String al) {
        this.al = al;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an;
    }

    public String getAo() {
        return ao;
    }

    public void setAo(String ao) {
        this.ao = ao;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAq() {
        return aq;
    }

    public void setAq(String aq) {
        this.aq = aq;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getTas() {
        return tas;
    }

    public void setTas(String tas) {
        this.tas = tas;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getAu() {
        return au;
    }

    public void setAu(String au) {
        this.au = au;
    }

    public String getAv() {
        return av;
    }

    public void setAv(String av) {
        this.av = av;
    }

    public String getAw() {
        return aw;
    }

    public void setAw(String aw) {
        this.aw = aw;
    }

    public String getAx() {
        return ax;
    }

    public void setAx(String ax) {
        this.ax = ax;
    }

    public String getAy() {
        return ay;
    }

    public void setAy(String ay) {
        this.ay = ay;
    }

    public String getAz() {
        return az;
    }

    public void setAz(String az) {
        this.az = az;
    }

    public String getBa() {
        return ba;
    }

    public void setBa(String ba) {
        this.ba = ba;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public String getBc() {
        return bc;
    }

    public void setBc(String bc) {
        this.bc = bc;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getBe() {
        return be;
    }

    public void setBe(String be) {
        this.be = be;
    }

    public String getBf() {
        return bf;
    }

    public void setBf(String bf) {
        this.bf = bf;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj;
    }

    public String getBk() {
        return bk;
    }

    public void setBk(String bk) {
        this.bk = bk;
    }

    public String getBl() {
        return bl;
    }

    public void setBl(String bl) {
        this.bl = bl;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getBn() {
        return bn;
    }

    public void setBn(String bn) {
        this.bn = bn;
    }

    @Override
    public String toString() {
        return "RawCsv{" +
                "id=" + id + System.lineSeparator() +
                ", rawData='" + rawData + '\'' + System.lineSeparator() +
                ", balancedData='" + balancedData + '\'' + System.lineSeparator() +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                ", e='" + e + '\'' +
                ", f='" + f + '\'' +
                ", g='" + g + '\'' +
                ", h='" + h + '\'' +
                ", i='" + i + '\'' +
                ", j='" + j + '\'' +
                ", k='" + k + '\'' +
                ", l='" + l + '\'' +
                ", m='" + m + '\'' +
                ", n='" + n + '\'' +
                ", o='" + o + '\'' +
                ", p='" + p + '\'' +
                ", q='" + q + '\'' +
                ", r='" + r + '\'' +
                ", s='" + s + '\'' +
                ", t='" + t + '\'' +
                ", u='" + u + '\'' +
                ", v='" + v + '\'' +
                ", w='" + w + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", z='" + z + '\'' +
                ", aa='" + aa + '\'' +
                ", ab='" + ab + '\'' +
                ", ac='" + ac + '\'' +
                ", ad='" + ad + '\'' +
                ", ae='" + ae + '\'' +
                ", af='" + af + '\'' +
                ", ag='" + ag + '\'' +
                ", ah='" + ah + '\'' +
                ", ai='" + ai + '\'' +
                ", aj='" + aj + '\'' +
                ", ak='" + ak + '\'' +
                ", al='" + al + '\'' +
                ", am='" + am + '\'' +
                ", an='" + an + '\'' +
                ", ao='" + ao + '\'' +
                ", ap='" + ap + '\'' +
                ", aq='" + aq + '\'' +
                ", ar='" + ar + '\'' +
                ", as='" + tas + '\'' +
                ", at='" + at + '\'' +
                ", au='" + au + '\'' +
                ", av='" + av + '\'' +
                ", aw='" + aw + '\'' +
                ", ax='" + ax + '\'' +
                ", ay='" + ay + '\'' +
                ", az='" + az + '\'' +
                ", ba='" + ba + '\'' +
                ", bb='" + bb + '\'' +
                ", bc='" + bc + '\'' +
                ", bd='" + bd + '\'' +
                ", be='" + be + '\'' +
                ", bf='" + bf + '\'' +
                ", bg='" + bg + '\'' +
                ", bh='" + bh + '\'' +
                ", bi='" + bi + '\'' +
                ", bj='" + bj + '\'' +
                ", bk='" + bk + '\'' +
                ", bl='" + bl + '\'' +
                ", bm='" + bm + '\'' +
                ", bn='" + bn + '\'' +
                '}';
    }
}

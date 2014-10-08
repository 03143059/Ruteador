/* RIPApplet - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RIPApplet extends Applet
        implements ActionListener, MouseListener
{
    Button StepButton;
    Button ResetButton;
    Font BigFont;
    Color redColor;
    Color blueColor;
    Color yellowColor;
    Color whiteColor;
    TextField Ptext11;
    TextField Ptext12;
    TextField Ptext13;
    TextField Ptext14;
    TextField Ptext15;
    TextField Ptext16;
    TextField Ptext17;
    TextField Ptext18;
    TextField Ptext19;
    TextField Ptext110;
    TextField Ptext111;
    TextField Ptext112;
    TextField Ptext113;
    TextField Ptext114;
    TextField Ptext115;
    TextField Ptext21;
    TextField Ptext22;
    TextField Ptext23;
    TextField Ptext24;
    TextField Ptext25;
    TextField Ptext26;
    TextField Ptext27;
    TextField Ptext28;
    TextField Ptext29;
    TextField Ptext210;
    TextField Ptext211;
    TextField Ptext212;
    TextField Ptext213;
    TextField Ptext214;
    TextField Ptext215;
    TextField Ptext31;
    TextField Ptext32;
    TextField Ptext33;
    TextField Ptext34;
    TextField Ptext35;
    TextField Ptext36;
    TextField Ptext37;
    TextField Ptext38;
    TextField Ptext39;
    TextField Ptext310;
    TextField Ptext311;
    TextField Ptext312;
    TextField Ptext313;
    TextField Ptext314;
    TextField Ptext315;
    TextField Ptext41;
    TextField Ptext42;
    TextField Ptext43;
    TextField Ptext44;
    TextField Ptext45;
    TextField Ptext46;
    TextField Ptext47;
    TextField Ptext48;
    TextField Ptext49;
    TextField Ptext410;
    TextField Ptext411;
    TextField Ptext412;
    TextField Ptext413;
    TextField Ptext414;
    TextField Ptext415;
    TextField Ptext51;
    TextField Ptext52;
    TextField Ptext53;
    TextField Ptext54;
    TextField Ptext55;
    TextField Ptext56;
    TextField Ptext57;
    TextField Ptext58;
    TextField Ptext59;
    TextField Ptext510;
    TextField Ptext511;
    TextField Ptext512;
    TextField Ptext513;
    TextField Ptext514;
    TextField Ptext515;
    int Minutes = 0;
    boolean flagLinea1 = false;
    boolean flagLinea2 = false;
    boolean flagpacket = false;
    boolean LinkAB = true;
    boolean LinkDE = true;
    int xl1 = 0;
    int yl1 = 0;
    int i = 1;
    int k = 0;
    int j = 0;
    int Nmin = 0;
    int q = 0;
    int l = 0;
    String ABS;
    String BAS;
    String DES;
    String EDS;
    String ACS = "-";
    String AES = "-";
    String BDS = "-";
    String DBS = "-";
    String DCS = "-";
    String EAS = "-";
    String CAS = "-";
    String CDS = "-";
    int ACN = 16;
    int AEN = 16;
    int BDN = 16;
    int CAN = 16;
    int CDN = 16;
    int DBN = 16;
    int DCN = 16;
    int EAN = 16;
    int ABN = 0;
    int BAN = 0;
    int DEN = 0;
    int EDN = 0;
    String ALinktoA = "A";
    String ALinktoB = "B";
    String ALinktoC = "-";
    String ALinktoD = "D";
    String ALinktoE = "-";
    int ANhopA = 0;
    int ANhopB = 1;
    int ANhopC = 16;
    int ANhopD = 1;
    int ANhopE = 16;
    String BLinktoA = "A";
    String BLinktoB = "B";
    String BLinktoC = "C";
    String BLinktoD = "-";
    String BLinktoE = "E";
    int BNhopA = 1;
    int BNhopB = 0;
    int BNhopC = 1;
    int BNhopD = 16;
    int BNhopE = 1;
    String DLinktoA = "A";
    String DLinktoB = "-";
    String DLinktoC = "-";
    String DLinktoD = "D";
    String DLinktoE = "E";
    int DNhopA = 1;
    int DNhopB = 16;
    int DNhopC = 16;
    int DNhopD = 0;
    int DNhopE = 1;
    String CLinktoA = "-";
    String CLinktoB = "B";
    String CLinktoC = "C";
    String CLinktoD = "-";
    String CLinktoE = "E";
    int CNhopA = 16;
    int CNhopB = 1;
    int CNhopC = 0;
    int CNhopD = 16;
    int CNhopE = 1;
    String ELinktoA = "-";
    String ELinktoB = "B";
    String ELinktoC = "C";
    String ELinktoD = "D";
    String ELinktoE = "E";
    int ENhopA = 16;
    int ENhopB = 1;
    int ENhopC = 1;
    int ENhopD = 1;
    int ENhopE = 0;
    TextField clockField;
    boolean running = false;

    public void actionPerformed(ActionEvent actionevent) {
        if (actionevent.getSource() == StepButton) {
            if (LinkAB && LinkDE) {
                if (ANhopB + BNhopC
                        > (ANhopD
                        + DNhopC)) {
                    ACN = (ANhopD
                            + DNhopC);
                    ACS = "D";
                } else {
                    ACN = (ANhopB
                            + BNhopC);
                    ACS = "B";
                }
                if (ANhopB + BNhopE
                        > (ANhopD
                        + DNhopE)) {
                    AEN = (ANhopD
                            + DNhopE);
                    ACS = "D";
                } else {
                    AEN = (ANhopD
                            + DNhopE);
                    AES = "D";
                }
                if ((BNhopA + ANhopD
                        >= (BNhopC
                        + CNhopD))
                        && ((BNhopC
                        + CNhopD)
                        >= (BNhopE
                        + ENhopD))) {
                    BDN = (BNhopE
                            + ENhopD);
                    BDS = "E";
                }
                if ((BNhopC + CNhopD
                        >= (BNhopA
                        + ANhopD))
                        && ((BNhopA
                        + ANhopD)
                        >= (BNhopE
                        + ENhopD))) {
                    BDN = (BNhopE
                            + ENhopD);
                    BDS = "E";
                }
                if ((BNhopC + CNhopD
                        >= (BNhopE
                        + ENhopD))
                        && ((BNhopE
                        + ENhopD)
                        >= (BNhopA
                        + ANhopD))) {
                    BDN = (BNhopA
                            + ANhopD);
                    BDS = "A";
                }
                if ((BNhopE + ENhopD
                        >= (BNhopC
                        + CNhopD))
                        && ((BNhopC
                        + CNhopD)
                        >= (BNhopA
                        + ANhopD))) {
                    BDN = (BNhopA
                            + ANhopD);
                    BDS = "A";
                }
                if ((BNhopA + ANhopD
                        >= (BNhopE
                        + ENhopD))
                        && ((BNhopE
                        + ENhopD)
                        >= (BNhopC
                        + CNhopD))) {
                    BDN = (BNhopC
                            + CNhopD);
                    BDS = "C";
                }
                if ((BNhopE + ENhopD
                        >= (BNhopA
                        + ANhopD))
                        && ((BNhopA
                        + ANhopD)
                        >= (BNhopC
                        + CNhopD))) {
                    BDN = (BNhopC
                            + CNhopD);
                    BDS = "C";
                }
                if (CNhopB + BNhopA
                        > (CNhopE
                        + ENhopA)) {
                    CAN = (CNhopE
                            + ENhopA);
                    CAS = "E";
                } else {
                    CAN = (CNhopB
                            + BNhopA);
                    CAS = "B";
                }
                if (CNhopB + BNhopD
                        > (CNhopE
                        + ENhopD)) {
                    CDN = (CNhopE
                            + ENhopD);
                    CDS = "E";
                } else {
                    CDN = (CNhopB
                            + BNhopD);
                    CDS = "B";
                }
                if (DNhopA + ANhopB
                        > (DNhopE
                        + ENhopB)) {
                    DBN = (DNhopE
                            + ENhopB);
                    DBS = "E";
                } else {
                    DBN = (DNhopA
                            + ANhopB);
                    DBS = "A";
                }
                if (DNhopA + ANhopC
                        > (DNhopE
                        + ENhopC)) {
                    DCN = (DNhopE
                            + ENhopC);
                    DCS = "E";
                } else {
                    DCN = (DNhopA
                            + ANhopC);
                    DCS = "A";
                }
                if ((ENhopB + BNhopA
                        >= (ENhopC
                        + CNhopA))
                        && ((ENhopC
                        + CNhopA)
                        >= (ENhopD
                        + DNhopA))) {
                    EAN = (ENhopD
                            + DNhopA);
                    EAS = "D";
                }
                if ((ENhopC + CNhopA
                        >= (ENhopB
                        + BNhopA))
                        && ((ENhopB
                        + BNhopA)
                        >= (ENhopD
                        + DNhopA))) {
                    EAN = (ENhopD
                            + DNhopA);
                    EAS = "D";
                }
                if ((ENhopD + DNhopD
                        >= (ENhopB
                        + BNhopA))
                        && ((ENhopB
                        + BNhopA)
                        >= (ENhopC
                        + CNhopA))) {
                    EAN = (BNhopA
                            + ANhopD);
                    EAS = "C";
                }
                if ((ENhopB + BNhopA
                        >= (ENhopD
                        + DNhopA))
                        && ((ENhopD
                        + DNhopA)
                        >= (ENhopC
                        + CNhopA))) {
                    EAN = (ENhopC
                            + CNhopA);
                    EAS = "C";
                }
                if ((ENhopC + CNhopA
                        >= (ENhopD
                        + DNhopA))
                        && ((ENhopD
                        + DNhopA)
                        >= (ENhopB
                        + BNhopA))) {
                    EAN = (ENhopB
                            + BNhopA);
                    EAS = "B";
                }
                if ((ENhopD + DNhopA
                        >= (ENhopC
                        + CNhopA))
                        && ((ENhopC
                        + CNhopA)
                        >= (ENhopB
                        + BNhopA))) {
                    EAN = (ENhopB
                            + BNhopA);
                    EAS = "B";
                }
            }
            if (LinkDE
                    && flagLinea1) {
                if (DNhopC < 16) {
                    ACN = (ANhopD
                            + DNhopC);
                    ACS = "D";
                }
                if (DNhopB < 16) {
                    ABN = (ANhopD
                            + DNhopB);
                    ABS = "D";
                }
                if (DNhopE < 16) {
                    AEN = (ANhopD
                            + DNhopE);
                    AES = "D";
                }
                if (CNhopA < 16
                        || ENhopA < 16) {
                    if ((BNhopC
                            + CNhopA)
                            > (BNhopE
                            + ENhopA)) {
                        BAN
                                = (BNhopE
                                + ENhopA);
                        BAS = "E";
                    } else {
                        BAN
                                = (BNhopC
                                + CNhopA);
                        BAS = "C";
                    }
                }
                if (CNhopC < 16
                        || ENhopD < 16) {
                    if ((BNhopC
                            + CNhopD)
                            > (BNhopE
                            + ENhopD)) {
                        BDN
                                = (BNhopE
                                + ENhopD);
                        BDS = "E";
                    } else {
                        BDN
                                = (BNhopC
                                + CNhopD);
                        BDS = "C";
                    }
                }
                if (BNhopA < 16
                        || ENhopA < 16) {
                    if ((CNhopB
                            + BNhopA)
                            > (CNhopE
                            + ENhopA)) {
                        CAN
                                = (CNhopE
                                + ENhopA);
                        CAS = "E";
                    } else {
                        CAN
                                = (CNhopB
                                + BNhopA);
                        CAS = "B";
                    }
                }
                if (CNhopB + BNhopD
                        > (CNhopE
                        + ENhopD)) {
                    CDN = (CNhopE
                            + ENhopD);
                    CDS = "E";
                } else {
                    CDN = (CNhopB
                            + BNhopD);
                    CDS = "B";
                }
                if (DNhopA + ANhopB
                        > (DNhopE
                        + ENhopB)) {
                    DBN = (DNhopE
                            + ENhopB);
                    DBS = "E";
                } else {
                    DBN = (DNhopA
                            + ANhopB);
                    DBS = "A";
                }
                if (DNhopA + ANhopC
                        > (DNhopE
                        + ENhopC)) {
                    DCN = (DNhopE
                            + ENhopC);
                    DCS = "E";
                } else {
                    DCN = (DNhopA
                            + ANhopC);
                    DCS = "A";
                }
                if ((ENhopB + BNhopA
                        >= (ENhopC
                        + CNhopA))
                        && ((ENhopC
                        + CNhopA)
                        >= (ENhopD
                        + DNhopA))) {
                    EAN = (ENhopD
                            + DNhopA);
                    EAS = "D";
                }
                if ((ENhopC + CNhopA
                        >= (ENhopB
                        + BNhopA))
                        && ((ENhopB
                        + BNhopA)
                        >= (ENhopD
                        + DNhopA))) {
                    EAN = (ENhopD
                            + DNhopA);
                    EAS = "D";
                }
                if ((ENhopD + DNhopD
                        >= (ENhopB
                        + BNhopA))
                        && ((ENhopB
                        + BNhopA)
                        >= (ENhopC
                        + CNhopA))) {
                    EAN = (BNhopA
                            + ANhopD);
                    EAS = "C";
                }
                if ((ENhopB + BNhopA
                        >= (ENhopD
                        + DNhopA))
                        && ((ENhopD
                        + DNhopA)
                        >= (ENhopC
                        + CNhopA))) {
                    EAN = (ENhopC
                            + CNhopA);
                    EAS = "C";
                }
                if ((ENhopC + CNhopA
                        >= (ENhopD
                        + DNhopA))
                        && ((ENhopD
                        + DNhopA)
                        >= (ENhopB
                        + BNhopA))) {
                    EAN = (ENhopB
                            + BNhopA);
                    EAS = "B";
                }
                if ((ENhopD + DNhopA
                        >= (ENhopC
                        + CNhopA))
                        && ((ENhopC
                        + CNhopA)
                        >= (ENhopB
                        + BNhopA))) {
                    EAN = (ENhopB
                            + BNhopA);
                    EAS = "B";
                }
            }
            if (LinkAB
                    && flagLinea2) {
                if (ANhopB + BNhopC
                        > (ANhopD
                        + DNhopC)) {
                    ACN = (ANhopD
                            + DNhopC);
                    ACS = "D";
                } else {
                    ACN = (ANhopB
                            + BNhopC);
                    ACS = "B";
                }
                if (BNhopE < 16
                        || DNhopE < 16) {
                    if ((ANhopB
                            + BNhopE)
                            > (ANhopD
                            + DNhopE)) {
                        AEN
                                = (ANhopD
                                + DNhopE);
                        AES = "D";
                    } else {
                        AEN
                                = (ANhopB
                                + BNhopE);
                        AES = "B";
                    }
                }
                if ((BNhopA + ANhopD
                        >= (BNhopC
                        + CNhopD))
                        && ((BNhopC
                        + CNhopD)
                        >= (BNhopE
                        + ENhopD))) {
                    BDN = (BNhopE
                            + ENhopD);
                    BDS = "E";
                }
                if ((BNhopC + CNhopD
                        >= (BNhopA
                        + ANhopD))
                        && ((BNhopA
                        + ANhopD)
                        >= (BNhopE
                        + ENhopD))) {
                    BDN = (BNhopE
                            + ENhopD);
                    BDS = "E";
                }
                if ((BNhopC + CNhopD
                        >= (BNhopE
                        + ENhopD))
                        && ((BNhopE
                        + ENhopD)
                        >= (BNhopA
                        + ANhopD))) {
                    BDN = (BNhopA
                            + ANhopD);
                    BDS = "A";
                }
                if ((BNhopE + ENhopD
                        >= (BNhopC
                        + CNhopD))
                        && ((BNhopC
                        + CNhopD)
                        >= (BNhopA
                        + ANhopD))) {
                    BDN = (BNhopA
                            + ANhopD);
                    BDS = "A";
                }
                if ((BNhopA + ANhopD
                        >= (BNhopE
                        + ENhopD))
                        && ((BNhopE
                        + ENhopD)
                        >= (BNhopC
                        + CNhopD))) {
                    BDN = (BNhopC
                            + CNhopD);
                    BDS = "C";
                }
                if ((BNhopE + ENhopD
                        >= (BNhopA
                        + ANhopD))
                        && ((BNhopA
                        + ANhopD)
                        >= (BNhopC
                        + CNhopD))) {
                    BDN = (BNhopC
                            + CNhopD);
                    BDS = "C";
                }
                if (CNhopB + BNhopA
                        > (CNhopE
                        + ENhopA)) {
                    CAN = (CNhopE
                            + ENhopA);
                    CAS = "E";
                } else {
                    CAN = (CNhopB
                            + BNhopA);
                    CAS = "B";
                }
                if (BNhopD < 16
                        || ENhopD < 16) {
                    if ((CNhopB
                            + BNhopD)
                            > (CNhopE
                            + ENhopD)) {
                        CDN
                                = (CNhopE
                                + ENhopD);
                        CDS = "E";
                    } else {
                        CDN
                                = (CNhopB
                                + BNhopD);
                        CDS = "B";
                    }
                }
                if (ANhopB < 16) {
                    DBN = (DNhopA
                            + ANhopB);
                    DBS = "A";
                }
                if (ANhopC < 16) {
                    DCN = (DNhopA
                            + ANhopC);
                    DCS = "A";
                }
                if (ANhopE < 16) {
                    DEN = (DNhopA
                            + ANhopE);
                    DES = "A";
                }
                if (CNhopA < 16
                        || BNhopA < 16) {
                    if ((ENhopB
                            + BNhopA)
                            > (ENhopC
                            + CNhopA)) {
                        EAN
                                = (ENhopC
                                + CNhopA);
                        EAS = "C";
                    } else {
                        EAN
                                = (ENhopB
                                + BNhopA);
                        EAS = "B";
                    }
                }
                if (BNhopD < 16
                        || CNhopD < 16) {
                    if ((ENhopB
                            + BNhopD)
                            > (ENhopC
                            + CNhopD)) {
                        EDN
                                = (ENhopC
                                + CNhopD);
                        EDS = "C";
                    } else {
                        EDN
                                = (ENhopB
                                + BNhopD);
                        EDS = "B";
                    }
                }
            }
            if (flagLinea1
                    && flagLinea2) {
                if (DNhopC < 16) {
                    if (DLinktoC == "A") {
                        ACN = 16;
                        ACS = "-";
                    } else {
                        ACN
                                = (ANhopD
                                + DNhopC);
                        ACS = "D";
                    }
                }
                if (DNhopB < 16) {
                    if (DLinktoB == "A") {
                        ABN = 16;
                        ABS = "-";
                    } else {
                        ABN
                                = (ANhopD
                                + DNhopB);
                        ABS = "D";
                    }
                }
                if (DNhopE < 16) {
                    if (DLinktoE == "A") {
                        AEN = 16;
                        AES = "-";
                    } else {
                        AEN
                                = (ANhopD
                                + DNhopE);
                        AES = "D";
                    }
                }
                if (CNhopA < 16
                        || ENhopA < 16) {
                    if ((BNhopC
                            + CNhopA)
                            > (BNhopE
                            + ENhopA)) {
                        BAN
                                = (BNhopE
                                + ENhopA);
                        BAS = "E";
                    } else {
                        BAN
                                = (BNhopC
                                + CNhopA);
                        BAS = "C";
                    }
                }
                if (CNhopC < 16
                        || ENhopD < 16) {
                    if ((BNhopC
                            + CNhopD)
                            > (BNhopE
                            + ENhopD)) {
                        BDN
                                = (BNhopE
                                + ENhopD);
                        BDS = "E";
                    } else {
                        BDN
                                = (BNhopC
                                + CNhopD);
                        BDS = "C";
                    }
                }
                if (BNhopA < 16
                        || ENhopA < 16) {
                    if ((CNhopB
                            + BNhopA)
                            > (CNhopE
                            + ENhopA)) {
                        CAN
                                = (CNhopE
                                + ENhopA);
                        CAS = "E";
                    } else {
                        CAN
                                = (CNhopB
                                + BNhopA);
                        CAS = "B";
                    }
                }
                if (CNhopB + BNhopD
                        > (CNhopE
                        + ENhopD)) {
                    CDN = (CNhopE
                            + ENhopD);
                    CDS = "E";
                } else {
                    CDN = (CNhopB
                            + BNhopD);
                    CDS = "B";
                }
                if (ANhopB < 16) {
                    if (ALinktoB == "D") {
                        DBN = 16;
                        DBS = "-";
                    } else {
                        DBN
                                = (DNhopA
                                + ANhopB);
                        DBS = "A";
                    }
                }
                if (ANhopC < 16) {
                    if (ALinktoC == "D") {
                        DCN = 16;
                        DCS = "-";
                    } else {
                        DCN
                                = (DNhopA
                                + ANhopC);
                        DCS = "A";
                    }
                }
                if (ANhopE < 16) {
                    if (ALinktoE == "D") {
                        DEN = 16;
                        DES = "-";
                    } else {
                        DEN
                                = (DNhopA
                                + ANhopE);
                        DES = "A";
                    }
                }
                if (CNhopA < 16
                        || BNhopA < 16) {
                    if ((ENhopB
                            + BNhopA)
                            > (ENhopC
                            + CNhopA)) {
                        EAN
                                = (ENhopC
                                + CNhopA);
                        EAS = "C";
                    } else {
                        EAN
                                = (ENhopB
                                + BNhopA);
                        EAS = "B";
                    }
                }
                if (BNhopD < 16
                        || CNhopD < 16) {
                    if ((ENhopB
                            + BNhopD)
                            > (ENhopC
                            + CNhopD)) {
                        EDN
                                = (ENhopC
                                + CNhopD);
                        EDS = "C";
                    } else {
                        EDN
                                = (ENhopB
                                + BNhopD);
                        EDS = "B";
                    }
                }
            }
            ANhopC = ACN;
            ALinktoC = ACS;
            ANhopE = AEN;
            ALinktoE = AES;
            BNhopD = BDN;
            BLinktoD = BDS;
            CNhopA = CAN;
            CLinktoA = CAS;
            CNhopD = CDN;
            CLinktoD = CDS;
            DNhopB = DBN;
            DLinktoB = DBS;
            DNhopC = DCN;
            DLinktoC = DCS;
            ENhopA = EAN;
            ELinktoA = EAS;
            if (flagLinea1) {
                ANhopB = ABN;
                ALinktoB = ABS;
                BNhopA = BAN;
                BLinktoA = BAS;
            }
            if (flagLinea2) {
                DNhopE = DEN;
                DLinktoE = DES;
                ENhopD = EDN;
                ELinktoD = EDS;
            }
            flagpacket = true;
            repaint();
        }
        actionevent.getSource();
    }

    public void init() {
        setLayout(null);
        StepButton = new Button("Step");
        ResetButton = new Button("Reset");
        Ptext11 = new TextField("A", 2);
        Ptext12
                = new TextField(String.valueOf(ANhopA), 2);
        Ptext13
                = new TextField(ALinktoA, 2);
        Ptext14 = new TextField("A", 2);
        Ptext15
                = new TextField(String.valueOf(BNhopA), 2);
        Ptext16
                = new TextField(BLinktoA, 2);
        Ptext17 = new TextField("A", 2);
        Ptext18
                = new TextField(String.valueOf(CNhopA), 2);
        Ptext19
                = new TextField(CLinktoA, 2);
        Ptext110 = new TextField("A", 2);
        Ptext111
                = new TextField(String.valueOf(DNhopA), 2);
        Ptext112
                = new TextField(DLinktoA, 2);
        Ptext113 = new TextField("A", 2);
        Ptext114
                = new TextField(String.valueOf(ENhopA), 2);
        Ptext115
                = new TextField(ELinktoA, 2);
        Ptext21 = new TextField("B", 2);
        Ptext22
                = new TextField(String.valueOf(ANhopB), 2);
        Ptext23
                = new TextField(ALinktoB, 2);
        Ptext24 = new TextField("B", 2);
        Ptext25
                = new TextField(String.valueOf(BNhopB), 2);
        Ptext26
                = new TextField(BLinktoB, 2);
        Ptext27 = new TextField("B", 2);
        Ptext28
                = new TextField(String.valueOf(CNhopB), 2);
        Ptext29
                = new TextField(CLinktoB, 2);
        Ptext210 = new TextField("B", 2);
        Ptext211
                = new TextField(String.valueOf(DNhopB), 2);
        Ptext212
                = new TextField(DLinktoB, 2);
        Ptext213 = new TextField("B", 2);
        Ptext214
                = new TextField(String.valueOf(ENhopB), 2);
        Ptext215
                = new TextField(ELinktoB, 2);
        Ptext31 = new TextField("C", 2);
        Ptext32
                = new TextField(String.valueOf(ANhopC), 2);
        Ptext33
                = new TextField(ALinktoC, 2);
        Ptext34 = new TextField("C", 2);
        Ptext35
                = new TextField(String.valueOf(BNhopC), 2);
        Ptext36
                = new TextField(BLinktoC, 2);
        Ptext37 = new TextField("C", 2);
        Ptext38
                = new TextField(String.valueOf(CNhopC), 2);
        Ptext39
                = new TextField(CLinktoC, 2);
        Ptext310 = new TextField("C", 2);
        Ptext311
                = new TextField(String.valueOf(DNhopC), 2);
        Ptext312
                = new TextField(DLinktoC, 2);
        Ptext313 = new TextField("C", 2);
        Ptext314
                = new TextField(String.valueOf(ENhopC), 2);
        Ptext315
                = new TextField(ELinktoC, 2);
        Ptext41 = new TextField("D", 2);
        Ptext42
                = new TextField(String.valueOf(ANhopD), 2);
        Ptext43
                = new TextField(ALinktoD, 2);
        Ptext44 = new TextField("D", 2);
        Ptext45
                = new TextField(String.valueOf(BNhopD), 2);
        Ptext46
                = new TextField(BLinktoD, 2);
        Ptext47 = new TextField("D", 2);
        Ptext48
                = new TextField(String.valueOf(CNhopD), 2);
        Ptext49
                = new TextField(CLinktoD, 2);
        Ptext410 = new TextField("D", 2);
        Ptext411
                = new TextField(String.valueOf(DNhopD), 2);
        Ptext412
                = new TextField(DLinktoD, 2);
        Ptext413 = new TextField("D", 2);
        Ptext414
                = new TextField(String.valueOf(ENhopD), 2);
        Ptext415
                = new TextField(ELinktoD, 2);
        Ptext51 = new TextField("E", 2);
        Ptext52
                = new TextField(String.valueOf(ANhopE), 2);
        Ptext53
                = new TextField(ALinktoE, 2);
        Ptext54 = new TextField("E", 2);
        Ptext55
                = new TextField(String.valueOf(BNhopE), 2);
        Ptext56
                = new TextField(BLinktoE, 2);
        Ptext57 = new TextField("E", 2);
        Ptext58
                = new TextField(String.valueOf(CNhopE), 2);
        Ptext59
                = new TextField(CLinktoE, 2);
        Ptext510 = new TextField("E", 2);
        Ptext511
                = new TextField(String.valueOf(DNhopE), 2);
        Ptext512
                = new TextField(DLinktoE, 2);
        Ptext513 = new TextField("E", 2);
        Ptext514
                = new TextField(String.valueOf(ENhopE), 2);
        Ptext515
                = new TextField(ELinktoE, 2);
        clockField = new TextField();
        BigFont = new Font("Arial", 1, 16);
        blueColor = Color.blue;
        redColor = Color.red;
        yellowColor = Color.yellow;
        whiteColor = Color.white;
        StepButton.setBounds(20, 70, 100, 30);
        ResetButton.setBounds(20, 130, 100, 30);
        Ptext11.setBounds(40, 270, 20, 20);
        Ptext12.setBounds(65, 270, 20, 20);
        Ptext13.setBounds(90, 270, 20, 20);
        Ptext14.setBounds(130, 270, 20, 20);
        Ptext15.setBounds(155, 270, 20, 20);
        Ptext16.setBounds(180, 270, 20, 20);
        Ptext17.setBounds(220, 270, 20, 20);
        Ptext18.setBounds(245, 270, 20, 20);
        Ptext19.setBounds(270, 270, 20, 20);
        Ptext110.setBounds(310, 270, 20, 20);
        Ptext111.setBounds(335, 270, 20, 20);
        Ptext112.setBounds(360, 270, 20, 20);
        Ptext113.setBounds(400, 270, 20, 20);
        Ptext114.setBounds(425, 270, 20, 20);
        Ptext115.setBounds(450, 270, 20, 20);
        Ptext21.setBounds(40, 295, 20, 20);
        Ptext22.setBounds(65, 295, 20, 20);
        Ptext23.setBounds(90, 295, 20, 20);
        Ptext24.setBounds(130, 295, 20, 20);
        Ptext25.setBounds(155, 295, 20, 20);
        Ptext26.setBounds(180, 295, 20, 20);
        Ptext27.setBounds(220, 295, 20, 20);
        Ptext28.setBounds(245, 295, 20, 20);
        Ptext29.setBounds(270, 295, 20, 20);
        Ptext210.setBounds(310, 295, 20, 20);
        Ptext211.setBounds(335, 295, 20, 20);
        Ptext212.setBounds(360, 295, 20, 20);
        Ptext213.setBounds(400, 295, 20, 20);
        Ptext214.setBounds(425, 295, 20, 20);
        Ptext215.setBounds(450, 295, 20, 20);
        Ptext31.setBounds(40, 320, 20, 20);
        Ptext32.setBounds(65, 320, 20, 20);
        Ptext33.setBounds(90, 320, 20, 20);
        Ptext34.setBounds(130, 320, 20, 20);
        Ptext35.setBounds(155, 320, 20, 20);
        Ptext36.setBounds(180, 320, 20, 20);
        Ptext37.setBounds(220, 320, 20, 20);
        Ptext38.setBounds(245, 320, 20, 20);
        Ptext39.setBounds(270, 320, 20, 20);
        Ptext310.setBounds(310, 320, 20, 20);
        Ptext311.setBounds(335, 320, 20, 20);
        Ptext312.setBounds(360, 320, 20, 20);
        Ptext313.setBounds(400, 320, 20, 20);
        Ptext314.setBounds(425, 320, 20, 20);
        Ptext315.setBounds(450, 320, 20, 20);
        Ptext41.setBounds(40, 345, 20, 20);
        Ptext42.setBounds(65, 345, 20, 20);
        Ptext43.setBounds(90, 345, 20, 20);
        Ptext44.setBounds(130, 345, 20, 20);
        Ptext45.setBounds(155, 345, 20, 20);
        Ptext46.setBounds(180, 345, 20, 20);
        Ptext47.setBounds(220, 345, 20, 20);
        Ptext48.setBounds(245, 345, 20, 20);
        Ptext49.setBounds(270, 345, 20, 20);
        Ptext410.setBounds(310, 345, 20, 20);
        Ptext411.setBounds(335, 345, 20, 20);
        Ptext412.setBounds(360, 345, 20, 20);
        Ptext413.setBounds(400, 345, 20, 20);
        Ptext414.setBounds(425, 345, 20, 20);
        Ptext415.setBounds(450, 345, 20, 20);
        Ptext51.setBounds(40, 370, 20, 20);
        Ptext52.setBounds(65, 370, 20, 20);
        Ptext53.setBounds(90, 370, 20, 20);
        Ptext54.setBounds(130, 370, 20, 20);
        Ptext55.setBounds(155, 370, 20, 20);
        Ptext56.setBounds(180, 370, 20, 20);
        Ptext57.setBounds(220, 370, 20, 20);
        Ptext58.setBounds(245, 370, 20, 20);
        Ptext59.setBounds(270, 370, 20, 20);
        Ptext510.setBounds(310, 370, 20, 20);
        Ptext511.setBounds(335, 370, 20, 20);
        Ptext512.setBounds(360, 370, 20, 20);
        Ptext513.setBounds(400, 370, 20, 20);
        Ptext514.setBounds(425, 370, 20, 20);
        Ptext515.setBounds(450, 370, 20, 20);
        clockField.setBounds(420, 170, 50, 30);
        add(StepButton);
        add(ResetButton);
        add(Ptext11);
        add(Ptext12);
        add(Ptext13);
        add(Ptext14);
        add(Ptext15);
        add(Ptext16);
        add(Ptext17);
        add(Ptext18);
        add(Ptext19);
        add(Ptext110);
        add(Ptext111);
        add(Ptext112);
        add(Ptext113);
        add(Ptext114);
        add(Ptext115);
        add(Ptext21);
        add(Ptext22);
        add(Ptext23);
        add(Ptext24);
        add(Ptext25);
        add(Ptext26);
        add(Ptext27);
        add(Ptext28);
        add(Ptext29);
        add(Ptext210);
        add(Ptext211);
        add(Ptext212);
        add(Ptext213);
        add(Ptext214);
        add(Ptext215);
        add(Ptext31);
        add(Ptext32);
        add(Ptext33);
        add(Ptext34);
        add(Ptext35);
        add(Ptext36);
        add(Ptext37);
        add(Ptext38);
        add(Ptext39);
        add(Ptext310);
        add(Ptext311);
        add(Ptext312);
        add(Ptext313);
        add(Ptext314);
        add(Ptext315);
        add(Ptext41);
        add(Ptext42);
        add(Ptext43);
        add(Ptext44);
        add(Ptext45);
        add(Ptext46);
        add(Ptext47);
        add(Ptext48);
        add(Ptext49);
        add(Ptext410);
        add(Ptext411);
        add(Ptext412);
        add(Ptext413);
        add(Ptext414);
        add(Ptext415);
        add(Ptext51);
        add(Ptext52);
        add(Ptext53);
        add(Ptext54);
        add(Ptext55);
        add(Ptext56);
        add(Ptext57);
        add(Ptext58);
        add(Ptext59);
        add(Ptext510);
        add(Ptext511);
        add(Ptext512);
        add(Ptext513);
        add(Ptext514);
        add(Ptext515);
        addMouseListener(this);
        add(clockField);
        StepButton.addActionListener(this);
        ResetButton.addActionListener(this);
        setBackground(whiteColor);
    }

    public void mouseClicked(MouseEvent mouseevent) {
        xl1 = mouseevent.getX();
        yl1 = mouseevent.getY();
        if (xl1 > 210 && xl1 < 310
                && yl1 > 60
                && yl1 < 70) {
            flagLinea1 = true;
            LinkAB = false;
            ALinktoB = "-";
            ABS = "-";
            BLinktoA = "-";
            BAS = "-";
            ANhopB = 16;
            ABN = 16;
            BNhopA = 16;
            BAN = 16;
            Ptext15
                    .setText(String.valueOf(BNhopA));
            Ptext16
                    .setText(BLinktoA);
            Ptext22
                    .setText(String.valueOf(ANhopB));
            Ptext23
                    .setText(ALinktoB);
        }
        if (xl1 > 210 && xl1 < 310
                && yl1 > 180
                && yl1 < 190) {
            flagLinea2 = true;
            LinkDE = false;
            DLinktoE = "-";
            DES = "-";
            ELinktoD = "-";
            EDS = "-";
            DNhopE = 16;
            DEN = 16;
            ENhopD = 16;
            EDN = 16;
            Ptext511
                    .setText(String.valueOf(DNhopE));
            Ptext512
                    .setText(DLinktoE);
            Ptext414
                    .setText(String.valueOf(ENhopD));
            Ptext415
                    .setText(ELinktoD);
        }
        repaint();
    }

    public void mouseEntered(MouseEvent mouseevent) {
	/* empty */
    }

    public void mouseExited(MouseEvent mouseevent) {
	/* empty */
    }

    public void mousePressed(MouseEvent mouseevent) {
	/* empty */
    }

    public void mouseReleased(MouseEvent mouseevent) {
	/* empty */
    }

    public void paint(Graphics graphics) {
        graphics.setFont(BigFont);
        graphics.setColor(redColor);
        graphics.fillArc(180, 50, 30, 30, 0, 360);
        graphics.fillArc(300, 50, 30, 30, 0, 360);
        graphics.fillArc(180, 170, 30, 30, 0, 360);
        graphics.fillArc(300, 170, 30, 30, 0, 360);
        graphics.fillArc(420, 50, 30, 30, 0, 360);
        graphics.setColor(blueColor);
        graphics.drawLine(330, 65, 420, 65);
        graphics.drawLine(195, 80, 195, 170);
        graphics.drawLine(315, 80, 315, 170);
        graphics.drawLine(330, 185, 435, 80);
        graphics.drawString("Node A", 45, 250);
        graphics.drawString("Node B", 135, 250);
        graphics.drawString("Node C", 225, 250);
        graphics.drawString("Node D", 315, 250);
        graphics.drawString("Node E", 405, 250);
        graphics.drawString("Clock (min:sec)", 425, 150);
        if (flagLinea1) {
            graphics.setColor(whiteColor);
            graphics.drawLine(210, 65, 300, 65);
        } else {
            graphics.setColor(blueColor);
            graphics.drawLine(210, 65, 300, 65);
        }
        if (flagLinea2) {
            graphics.setColor(whiteColor);
            graphics.drawLine(210, 185, 300, 185);
        } else {
            graphics.setColor(blueColor);
            graphics.drawLine(210, 185, 300, 185);
        }
        graphics.setColor(whiteColor);
        graphics.drawString("A", 190, 70);
        graphics.drawString("B", 310, 70);
        graphics.drawString("C", 430, 70);
        graphics.drawString("D", 190, 190);
        graphics.drawString("E", 310, 190);
        graphics.setColor(blueColor);
        if (flagpacket) {
            i = 0;
            l = 0;
            if (q == 1) {
                Nmin = Nmin + 1;
                q = 0;
                clockField
                        .setText(Nmin + "" + ":" + "00");
            } else {
                clockField
                        .setText(Nmin + "" + ":" + "30");
                q = q + 1;
            }
            while (i < 93) {
                k = 0;
                j = 0;
                if (i < 77) {
                    if (LinkAB) {
                        graphics.setColor(whiteColor);
                        graphics.fillRect(211 + i - 1, 50,
                                12, 7);
                        graphics.setColor(blueColor);
                        graphics.fillRect(211 + i, 50, 12,
                                7);
                        graphics.setColor(whiteColor);
                        graphics.fillRect(288 - i + 1, 70,
                                12, 7);
                        graphics.setColor(blueColor);
                        graphics.fillRect(288 - i, 70, 12,
                                7);
                    }
                    if (LinkDE) {
                        graphics.setColor(whiteColor);
                        graphics.fillRect(212 + i - 1,
                                170, 12, 7);
                        graphics.setColor(blueColor);
                        graphics.fillRect(212 + i, 170,
                                12, 7);
                        graphics.setColor(whiteColor);
                        graphics.fillRect(288 - i + 1,
                                190, 12, 7);
                        graphics.setColor(blueColor);
                        graphics.fillRect(288 - i, 190,
                                12, 7);
                    }
                    graphics.setColor(whiteColor);
                    graphics.fillRect(330 + i - 1, 50, 12,
                            7);
                    graphics.setColor(blueColor);
                    graphics.fillRect(330 + i, 50, 12, 7);
                    graphics.setColor(whiteColor);
                    graphics.fillRect(408 - i + 1, 70, 12,
                            7);
                    graphics.setColor(blueColor);
                    graphics.fillRect(408 - i, 70, 12, 7);
                    graphics.setColor(whiteColor);
                    graphics.fillRect(200, 80 + i - 1, 7,
                            12);
                    graphics.setColor(blueColor);
                    graphics.fillRect(200, 80 + i, 7, 12);
                    graphics.setColor(whiteColor);
                    graphics.fillRect(180, 160 - i + 1, 7,
                            12);
                    graphics.setColor(blueColor);
                    graphics.fillRect(180, 160 - i, 7,
                            12);
                    graphics.setColor(whiteColor);
                    graphics.fillRect(320, 80 + i - 1, 7,
                            12);
                    graphics.setColor(blueColor);
                    graphics.fillRect(320, 80 + i, 7, 12);
                    graphics.setColor(whiteColor);
                    graphics.fillRect(303, 158 - i + 1, 7,
                            12);
                    graphics.setColor(blueColor);
                    graphics.fillRect(303, 158 - i, 7,
                            12);
                    if (i < 60) {
                        graphics.setColor(whiteColor);
                        graphics.fillRect(450 - 2 * i + 2,
                                80 + 2 * i - 2,
                                12, 7);
                        graphics.setColor(blueColor);
                        graphics.fillRect(450 - 2 * i,
                                80 + 2 * i, 12,
                                7);
                    }
                    if (i < 45) {
                        graphics.setColor(whiteColor);
                        graphics.fillRect(325 + 2 * i - 2,
                                165 - 2 * i + 2,
                                12, 7);
                        graphics.setColor(blueColor);
                        graphics.fillRect(325 + 2 * i,
                                165 - 2 * i, 12,
                                7);
                    }
                } else {
                    graphics.setColor(whiteColor);
                    graphics.fillRect(274 + l, 50, 12, 7);
                    graphics.fillRect(225 - l, 70, 12, 7);
                    graphics.fillRect(274 + l, 170, 12,
                            7);
                    graphics.fillRect(225 - l, 190, 12,
                            7);
                    graphics.fillRect(345 - l, 70, 12, 7);
                    graphics.fillRect(393 + l, 50, 12, 7);
                    graphics.fillRect(200, 143 + l, 7,
                            12);
                    graphics.fillRect(180, 97 - l, 7, 12);
                    graphics.fillRect(320, 143 + l, 7,
                            12);
                    graphics.fillRect(303, 97 - l, 7, 12);
                    if (l < 6)
                        graphics.fillRect(403 + 2 * l,
                                87 - 2 * l, 12,
                                7);
                    graphics.fillRect(342 - 2 * l,
                            188 + 2 * l, 12, 7);
                    l = l + 1;
                }
                i = i + 1;
                while (k < 400000) {
                    for (/**/; j < 2;
                             j = j + 1) {
			/* empty */
                    }
                    k = k + 1;
                    j = 0;
                }
            }
            Ptext32
                    .setText(String.valueOf(ANhopC));
            Ptext33
                    .setText(ALinktoC);
            Ptext52
                    .setText(String.valueOf(ANhopE));
            Ptext53
                    .setText(ALinktoE);
            Ptext45
                    .setText(String.valueOf(BNhopD));
            Ptext46
                    .setText(BLinktoD);
            Ptext18
                    .setText(String.valueOf(CNhopA));
            Ptext19
                    .setText(CLinktoA);
            Ptext48
                    .setText(String.valueOf(CNhopD));
            Ptext49
                    .setText(CLinktoD);
            Ptext211
                    .setText(String.valueOf(DNhopB));
            Ptext212
                    .setText(DLinktoB);
            Ptext311
                    .setText(String.valueOf(DNhopC));
            Ptext312
                    .setText(DLinktoC);
            Ptext114
                    .setText(String.valueOf(ENhopA));
            Ptext115
                    .setText(ELinktoA);
            Ptext22
                    .setText(String.valueOf(ANhopB));
            Ptext23
                    .setText(ALinktoB);
            Ptext15
                    .setText(String.valueOf(BNhopA));
            Ptext16
                    .setText(BLinktoA);
            Ptext511
                    .setText(String.valueOf(DNhopE));
            Ptext512
                    .setText(DLinktoE);
            Ptext414
                    .setText(String.valueOf(ENhopD));
            Ptext415
                    .setText(ELinktoD);
            flagpacket = false;
        }
    }
}

package main.atziji.java.test;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhuqiuping on 2019/9/29
 */
public class ArraysTest {


    private static String START_AT = "_start_at";

    private static Map<String, Object>[] collators;

    private String mapJson = " {\"facility\": 0,\"host\":\"ezsonar_host\",\"_rpo_playback_body\":\"GhgAAA4xMDEwMDAwMDAwMFg4MTIyLjUuMjUzLjEwNyA gICAgICAgICAgICAgICAgICAgICAgICAgIDIxMDAwICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgPD94bWwgdmVyc2lvbj0iMS4wIiBlb mNvZGluZz0iVVRGLTgiPz4KPHJvb3Q +CiAgPGNvbnRyb2xfZGF0YV9hcmVhPgogICAgPHZyc25fbnVtLz4KICAgIDxtZXNnX3R5cD4wMTAwPC9tZXN nX3R5cD4KICAgIDxtdXRwX3BhZ19xdXJ5X2ZsZy8+CiAgICA8ZHlubV9hdGhvX2ZsZy8+CiAgICA8c3Rya19iYW xjX2ZsZz5OPC9zdHJrX2JhbGNfZmxnPgogICAgPHNlbWlfYXV0bV9jaGFnX2RhdGFfZmxnLz4KICAgIDxub3RfZ mluY19ic2luX2hpc3RfcmNyZF9mbGcvPgogICAgPHNydmVfYnJhaF9pbnB0X21vZGUvPgogIDwvY29udHJvbF9 kYXRhX2FyZWE +CiAgPHNlcnZfY2FsbF9hcmVhPgogICAgPGFmbHRfYnNpbl9zeXN0X2NvZC8+CiAgICA8dG1ubF90eXA +TiMjIzwvdG1ubF90eXA +CiAgICA8dG1ubF9udW1fbGVuZ18xND5JTlRFUk5FVDwvdG1ubF9udW1fbGVuZ18xND4KICAgIDx0cmFuX2N vZF9jbnRuX2FwbHlfY29kPjAyMDA2MTE8L3RyYW5fY29kX2NudG5fYXBseV9jb2Q +CiAgICA8aW50b3JfdHJhbl9jb2Q+MDIwMDYxMTwvaW50b3JfdHJhbl9jb2Q +CiAgICA8YmFua19udW0+MDAxPC9iYW5rX251bT4KICAgIDxjcnNwX2JhbmtfbnVtLz4KICAgIDxjcm9zX2xlZ 2xfcGVzbl9wcmNzX2RyZWNfZmxnLz4KICAgIDx0cmFuX29yZ25fbnVtLz4KICAgIDx1c2VyX25hbT4wMTc5PC 91c2VyX25hbT4KICAgIDxyZXZ3X3VzZXIvPgogICAgPGludG9yX3N5c3RfY29kPkdDTVM8L2ludG9yX3N5c3Rf Y29kPgogICAgPGludG9yX3RyYW5fam5hbF9udW0+R0NNUzIwMjIxMjIwMTAxNzA3MDAwOTMwbW14bnBu cnV6bnd5PC9pbnRvcl90cmFuX2puYWxfbnVtPgogICAgPGludG9yX3N5c3RfZGF0ZT4yMDIyMTIyMDwvaW50 b3Jfc3lzdF9kYXRlPgogICAgPGFwbHlfc3lzdF90bXRwPjIwMjItMTItMjAtMTAuMTcuMDcuMDAwOTMwPC9hc Gx5X3N5c3RfdG10cD4KICAgIDxpbnRvcl9zeXN0X3RpbWU+MTAxNzA3PC9pbnRvcl9zeXN0X3RpbWU +CiAgICA8dHJhbl9jYWxsX3NlcXVfbnVtLz4KICAgIDx0cmFuX3NlcXVfbnVtX2dlbnJfc3lzdF9jb2QvPgogICAgP GZybnRfZW5kX3N5c3RfY29kLz4KICAgIDxmcm50X2VuZF9ic2luX2puYWxfbnVtLz4KICAgIDxleGhnX3BsZm1 fYnNpbl9kYXRlPjIwMjIwMTE4PC9leGhnX3BsZm1fYnNpbl9kYXRlPgogICAgPGV4aGdfcGxmbV90bXRwPjIwM jItMDEtMTgtMTAuMTcuNDQuODUwMDAwPC9leGhnX3BsZm1fdG10cD4KICAgIDxmcm50X2VuZF9zeXN0X3 RpbWUvPgogICAgPHRocmRfcGF0eV90cmFuX3N5c3RfY29kLz4KICAgIDx0aHJkX3BhcnRfc3lzdF9yZWZyX25 1bS8+CiAgICA8dGhyZF9wYXJ0X3N5c3RfZmxnLz4KICAgIDx1c2VyX3Nlc25fbnVtLz4KICAgIDxlbmNyX2ZldHJ fdmx1PjgxMTE3MDEwMTMzMDAyNTMwMzU8L2VuY3JfZmV0cl92bHU" +
            " +CiAgICA8c3R0Y19hdGhvX2RyY3IvPgogICAgPHN0dGNfYXRob19hdXRoX21vZGUvPgogICAgPGR5bm1fYXRo b19kcmNyLz4KICAgIDxkeW5tX2F0aG9fYXV0aF9tb2RlLz4KICAgIDxtdXRwX3BhZ19xdXJ5X3Rva2UvPgogICA gPG11dHBfcGFnX3F1cnlfc3RydF9yY3JkX251bS8+CiAgICA8bXV0cF9wYWdfcXVyeV9waWVjX251bS8+CiAgI CA8bXV0cF9wYWdfcXVyeV90bXRwLz4KICAgIDxpbnRvcl9kc3R0X2ZsZz4yPC9pbnRvcl9kc3R0X2ZsZz4KICA gIDxlbnRwX2hhZGxfcGVzbi8+CiAgICA8ZW50cF9oYWRsX3Blc25fbmFtLz4KICAgIDxlbnRwX3J2d3IvPgogICA gPGVudHBfY2hrcl9wZXNuX25hbS8+CiAgICA8YWNjdF9sYXlyX2ltYWdfaWQvPgogICAgPHRyYW5fbXRybF9 pbWFnX2lkLz4KICAgIDxpZF9pZF9pbWFnLz4KICAgIDx2bGR0X3ByaXRfbnVtLz4KICAgIDxmcnN0X3ZsZHRfZ mxnLz4KICAgIDxwcnBvX2VuY3Jfbm9kX251bS8+CiAgICA8YWJzdF9jb2QvPgogICAgPHNpZ25fY3RydF9jaGN rX2NvZC8+CiAgICA8ZXhoZ19yYXQvPgogICAgPG5lc2Jfam5hbF9udW0+MDMyMzEyMzk4NDg3PC9uZXNiX2p uYWxfbnVtPgogICAgPHRyYW5fbWVzZ19lbmNyX3R5cGU+MDA8L3RyYW5fbWVzZ19lbmNyX3R5cGU +CiAgICA8dHJhbl9tZXNnX2N5Y2xfY250PjAwPC90cmFuX21lc2dfY3ljbF9jbnQ +CiAgICA8aW50b3JfaXBfYWRkci8+CiAgPC9zZXJ2X2NhbGxfYXJlYT4KICA8aW5wdXRfZGF0YV9hcmVhPgogI CAgPGR5bm1fYXRob19yZWFzX2NudC8+CiAgICA8ZHlubV9hdGhvX3JlYXNfZGF0YV9saXN0Lz4KICAgIDxjaGF nX3RyYW5fY29kLz4KICAgIDxzZW1pX2F1dG1fZmVlX2RhdGFfY250Lz4KICAgIDxzZW1pX2F1dG1fZmVlX2Rh dGFfaW5fZGF0YV9saXN0Lz4KICAgIDx0cmNrX2JzaW5fZGF0YV9jbnQvPgogICAgPHRyY2tfYnNpbl9kYXRhPg ogICAgICA8dHJja19ic2luX2luZm9fMS8+CiAgICAgIDx0cmNrX2JzaW5faW5mb18yLz4KICAgICAgPHRyY2tfYn Npbl9pbmZvXzMvPgogICAgPC90cmNrX2JzaW5fZGF0YT4KICAgIDxhZ250X2JzaW5faW5mb19jbnQvPgogICA gPGFnbnRfYnNpbl9pbmZvPgogICAgICA8Y3VzdF9udW0vPgogICAgICA8Y3VzdF9hY2N0X251bS8+CiAgICAgI DxhZ250X3JlbGEvPgogICAgICA8YWdudF9pZF9jYXJkX3R5cC8+CiAgICAgIDxhZ250X2lkX2NhcmRfbnVtLz4KI CAgICAgPGlkX3R5cF8xLz4KICAgICAgPGlkX251bV8xLz4KICAgICAgPGFnbnRfcGVzbl9uYW0vPgogICAgICA8Y" +
            "" +
            " WdudF9jbnRhX3RscGgvPgogICAgICA8YWdudF9uYXRpLz4KICAgICAgPGFnbnRfYnJ0aF9kYXRlLz4KICAgICAg PGFnbnRfYWRkci8+CiAgICAgIDxhZ250X2lkX2V4cGlfZGF0ZS8+CiAgICAgIDxub3RlLz4KICAgICAgPGFnbnRfc mVhcy8+CiAgICAgIDxhY2N0X3NlcXVfbnVtLz4KICAgICAgPGF1eHlfZmVsZC8+CiAgICA8L2FnbnRfYnNpbl9p bmZvPgogICAgPGNhbmxfbG9hZF9ic2luX2luZm9fY250Lz4KICAgIDxjYW5sX2xvYWRfYnNpbl9pbmZvPgogIC AgICA8c3BjbF9ic2luX251bS8+CiAgICAgIDxjdXN0X2FjY3RfbnVtLz4KICAgIDwvY2FubF9sb2FkX2JzaW5faW5 mbz4KICAgIDxkYXRhX2Jmb3JfbW9kZi8+CiAgICA8cmVjcF9hZGRsX2RhdGEvPgogICAgPHBheV92bGR0X2Rhd GFfY250Lz4KICAgIDxwYXlfdmxkdF9kYXRhPgogICAgICA8cGF5X3ZsZHRfbWFza19jb2QvPgogICAgICA8cGF5 X3ZsZHRfY29kX3R5cC8+CiAgICAgIDxwYXlfdmxkdF9jb2QvPgogICAgICA8cGF5X3ZsZHRfY29kX251bS8+CiA gICA8L3BheV92bGR0X2RhdGE+CiAgPC9pbnB1dF9kYXRhX2FyZWE+CiAgPGJzaW5fcHJpdl9kb21uX3JxZXQ +CiAgICA8Y3VzdF9hY3RudW0+ODExMTcwMTAxMzMwMDI1MzAzNTwvY3VzdF9hY3RudW0+CiAgICA8YW NjdF9zcW51bS8+CiAgICA8Y2N5X2RndGxfY29kLz4KICAgIDxjYXNoX3JtaXRfZmxnLz4KICAgIDx2bGR0X21vZ GU +MTwvdmxkdF9tb2RlPgogICAgPGlkX3R5cC8+CiAgICA8aWRfbnVtLz4KICAgIDxhY2N0X3B3ZC8+CiAgICA8Y XV4eV9kb21uLz4KICA8L2JzaW5fcHJpdl9kb21uX3JxZXQ+Cjwvcm9vdD4K\",\"_trans_ref\": {\"GeoIP\":\"113.230.87.247\",\"data_bfor_modf\":\"\",\"intor_syst_date\":\"20221220\",\"TermNum\":\"01070806\",\"impea ch\": 0,\"revw_user\":\"\",\"CustomerID\":\"ODvMRVXQS_eOcnGEjwOFlA\",\"mutp_pag_qury_flg\":\"\",\"user_sesn_num\":\"\",\"e ntp_hadl_pesn\":\"\",\"dynm_atho_reas_cnt\":\"\",\"freeze\": 1,\"intor_dstt_flg\":\"2\",\"intor_syst_time\":\"101707\",\"recp_addl_data\":\"\",\"id_id_imag\":\"\",\"semi_autm_fee_data_i n_data_list\":\"\",\"trck_bsin_data\":\"\",\"bank_num\":\"001\",\"S0\":\"1czMVRhaTWS4fo4ynFaLPw\",\"mutp_pag_qury_pi ec_num\":\"\",\"exhg_rat\":\"\",\"aTMID\":\"109207\",\"frnt_end_bsin_jnal_num\":\"\",\"semi_autm_fee_data_cnt\":\"\",\"canl_ load_bsin_info\":\"\",\"vldt_prit_num\":\"\",\"TRX_CODE\":\"711041\",\"intor_ip_addr\":\"\",\"tran_orgn_num\":\"\",\"mutp_pa g_qury_tmtp\":\"\",\"thrd_part_syst_flg\":\"\",\"UPDATE_SQL\":\"update ezsonar_steam a set a.inout_status = 5 where a.apply_id in ('500000264272571','500000264272570')\",\"abc\":\"7gya3kT3RPKHjFN5D6l9jw\",\"sttc_atho_auth_mode\":\"\",\"TIA RSJN\":\"909639\",\"chag_tran_cod\":\"\",\"intor_tran_jnal_num\":\"GCMS20221220101707000930mmxnpnruznwy\",\" dynm_atho_drcr\":\"\",\"mesg_typ\":\"0100\",\"tran_mesg_cycl_cnt\":\"00\",\"strk_balc_flg\":\"N\",\"BusiOrgNum\":\"4600\",\" pay_vldt_data\":\"\",\"thrd_part_syst_refr_num\":\"\",\"prpo_encr_nod_num\":\"\",\"thrd_paty_tran_syst_cod\":\"\",\"user _nam\":\"0179\",\"semi_autm_chag_data_flg\":\"\",\"aply_syst_tmtp\":\"2022-12-20-10.17.07.000930\",\"vrsn_num\":\"\" ,\"entp_rvwr\":\"\",\"tran_sequ_num_genr_syst_cod\":\"\",\"dynm_atho_flg\":\"\",\"tmnl_typ\":\"N###\",\"aflt_bsin_syst_c od\":\"\",\"SELECT_SQL\":\"SELECT * FROM ezsonar_topo from 123456 hx_zs.zs_sky_kkxx a left join dm_gy_swjg b on a.sjgsdq= b.SWJG_DM from hx_zs.zs_sky_kkxx a left join dm_gy_swjg b on a.sjgsdq= b.SWJG_DM from hx_zs.zs_sky_kkxx a left join dm_gy_swjg b on a.sjgsdq= b.SWJG_DM from hx_zs.zs_sky_kkxx a left join dm_gy_swjg b on a.sjgsdq= b.SWJG_DM\",\"intor_tran_cod\":\"0200611\",\"entp_chkr_pesn_nam\":\"\",\"dynm_atho_reas_data_list\":\"\",\"trck_bsi n_data_cnt\":\"\",\"sttc_atho_drcr\":\"\",\"frnt_end_syst_time\":\"\",\"mutp_pag_qury_strt_rcrd_num\":\"\",\"tran_call_se qu_num\":\"\",\"not_finc_bsin_hist_rcrd_flg\":\"\",\"mutp_pag_qury_toke\":\"\",\"abst_cod\":\"\",\"INSERT_SQL\":\"insert into ezsonar_topo (new_exp_order,back_order,change_order,comp_exp_order,)select decode(a.nrmsuborder,'',0,a.nrmsuborder),a.exchnagedproduct,from upbms.HA_REPORT_ORDER_DELIVPROV@hplink a, ngves3.cm_province_info b where a.delivprovince = b.hp_code and a.calcudate BETWEEN 20140317 AND 20140320\",\"encr_fetr_vlu\":\"8111701013300253035\",\"intor_syst_cod\":\"GCMS\",\"HouseAddress\":\"168号 院\",\"rpo_playback\": 1,\"AccType\":\"A\",\"tmnl_num_leng_14\":\"INTERNET\",\"pay_vldt_data_cnt\":\"\",\"entp_hadl_pesn_nam\":\"\",\"canl_lo ad_bsin_info_cnt\":\"\",\"frnt_end_syst_cod\":\"\",\"exhg_plfm_bsin_date\":\"20220118\",\"sign_ctrt_chck_cod\":\"\",\"Bra nch\":\"01\",\"tran_mesg_encr_type\":\"00\",\"exhg_plfm_tmtp\":\"2022-01-18-10.17.44.850000\",\"tran_cod_cntn_ap ly_cod\":\"0200611\",\"frst_vldt_flg\":\"\",\"amount\": 63.22,\"SELECT_SQL_hash\":-5104018137356550000,\"agnt_bsin_info\":\"\",\"acct_layr_imag_id\":\"\",\"crsp_bank_n um\":\"\",\"srve_brah_inpt_mode\":\"\",\"INSERT_SQL_hash\":-8219880885498281000,\"agnt_bsin_info_cnt\":\"\",\"dynm" +
            "" +
            " _atho_auth_mode\":\"\",\"cros_legl_pesn_prcs_drec_flg\":\"\",\"UPDATE_SQL_hash\":-1813117092691806700,\"tran _mtrl_imag_id\":\"\",\"nesb_jnal_num\":\"032312398487\"},\"_rpo_resp\":\"<root> <return_data> <this_acct_date>20221220</this_acct_date> <mutp_pag_qury_piec_num>0000</ mutp_pag_qury_piec_num> <tmnl_num_leng_14>INTERNET</tmnl_num_leng_14> <info_typ>E</ info_typ> <tran_cod_cntn_aply_cod>0200611</tran_cod_cntn_aply_cod> <mutp_qury_prsd_cnt>000000000</mutp_qury_prsd_cnt> <intor_tran_cod>0200611</intor_tran_cod> <mesg_id>PMRA888</mesg_id> <retn_info_desc>获取交易网点失败!&amp;1,&amp;2,&amp;3</ retn_info_desc> <intor_tran_jnal_num>GCMS20221220101707000930mmxnpnruznwy</ intor_tran_jnal_num> <mesg_typ>0110</mesg_typ> <tran_log_num>SC010128416745</tran_log_num> <rspn_cod>30</rspn_cod> <tran_mesg_cycl_cnt>00</tran_mesg_cycl_cnt> <tran_call_sequ_num>000</ tran_call_sequ_num> <bank_num>001</bank_num> <mutp_pag_qury_rcrd_sum>0000</ mutp_pag_qury_rcrd_sum> <nesb_jnal_num>032312398487</nesb_jnal_num> </return_data> <transaction_ouput_data> <mesg_data_list> <mesg_data> <mesg_id>PMRA888</mesg_id> <mesg_txt>获取交易网点失败!&amp;1,&amp;2,&amp;3</mesg_txt> </mesg_data> </mesg_data_list> <mesg_cntt_cnt>01</mesg_cntt_cnt> <fee_data_out_area_cnt>00</fee_data_out_area_cnt> <recp_data_cnt>00</recp_data_cnt> </transaction_ouput_data> <control_area> <strk_balc_flg>N</ strk_balc_flg> <mutp_pag_qury_flg>N</mutp_pag_qury_flg> </control_area> </root> \",\"_trans_id\":\"F5-jiejika\",\"_is_success\":-1,\"_rpo_req_body\":\"<bsin_priv_domn_rqet> <cust_actnum>8111701013300253035</cust_actnum> <acct_sqnum /> <ccy_dgtl_cod /> <cash_rmit_flg /> <vldt_mode>1</vldt_mode> <id_typ /> <id_num /> <acct_pwd /> <auxy_domn /> </bsin_priv_domn_rqet> \",\"_sport\":35696,\"_start_at_s\":\"2019-09-28T17:17:30\",\"_protocol\": 6,\"_rpo_req_header\":\"<control_data_area> <vrsn_num /> <mesg_typ>0100</mesg_typ> <mutp_pag_qury_flg /> <dynm_atho_flg /> <strk_balc_flg>N</strk_balc_flg> <semi_autm_chag_data_flg /> <not_finc_bsin_hist_rcrd_flg /> <srve_brah_inpt_mode /> </ control_data_area> <serv_call_area> <aflt_bsin_syst_cod /> <tmnl_typ>N###</tmnl_typ> <tmnl_num_leng_14>INTERNET</tmnl_num_leng_14> <tran_cod_cntn_aply_cod>0200611</ tran_cod_cntn_aply_cod> <intor_tran_cod>0200611</intor_tran_cod> <bank_num>001</bank_num> <crsp_bank_num /> <cros_legl_pesn_prcs_drec_flg /> <tran_orgn_num /> <user_nam>0179</ user_nam> <revw_user /> <intor_syst_cod>GCMS</intor_syst_cod> <intor_tran_jnal_num>GCMS20221220101707000930mmxnpnruznwy</intor_tran_jnal_num> <intor_syst_date>20221220</intor_syst_date> <aply_syst_tmtp>2022-12-20-10.17.07.000930</ aply_syst_tmtp> <intor_syst_time>101707</intor_syst_time> <tran_call_sequ_num /> <tran_sequ_num_genr_syst_cod /> <frnt_end_syst_cod /> <frnt_end_bsin_jnal_num /> <exhg_plfm_bsin_date>20220118</exhg_plfm_bsin_date> <exhg_plfm_tmtp>2022-01-18-10.17.44.850000</exhg_plfm_tmtp> <frnt_end_syst_time /> <thrd_paty_tran_syst_cod /> <thrd_part_syst_refr_num /> <thrd_part_syst_flg /> <user_sesn_num /> <encr_fetr_vlu>8111701013300253035</encr_fetr_vlu> <sttc_atho_drcr /> <sttc_atho_auth_mode /> <dynm_atho_drcr /> <dynm_atho_auth_mode /> <mutp_pag_qury_toke /> <mutp_pag_qury_strt_rcrd_num /> <mutp_pag_qury_piec_num /> <mutp_pag_qury_tmtp /> <intor_dstt_flg>2</intor_dstt_flg> <entp_hadl_pesn /> <entp_hadl_pesn_nam /> <entp_rvwr /> <entp_chkr_pesn_nam /> <acct_layr_imag_id /> <tran_mtrl_imag_id /> <id_id_imag /> <vldt_prit_num /> <frst_vldt_flg /> <prpo_encr_nod_num /> <abst_cod /> <sign_ctrt_chck_cod /> <exhg_rat /> <nesb_jnal_num>032312398487</nesb_jnal_num> <tran_mesg_encr_type>00</ tran_mesg_encr_type> <tran_mesg_cycl_cnt>00</tran_mesg_cycl_cnt> <intor_ip_addr /> </ serv_call_area> <input_data_area> <dynm_atho_reas_cnt /> <dynm_atho_reas_data_list /> <chag_tran_cod /> <semi_autm_fee_data_cnt /> <semi_autm_fee_data_in_data_list /> <trck_bsin_data_cnt /> <trck_bsin_data> <trck_bsin_info_1 /> <trck_bsin_info_2 /> <trck_bsin_info_3 /> </trck_bsin_data> <agnt_bsin_info_cnt /> <agnt_bsin_info> <cust_num /> <cust_acct_num /> <agnt_rela /> <agnt_id_card_typ /> <agnt_id_card_num /> <id_typ_1 />" +
            "" +
            " <id_num_1 /> <agnt_pesn_nam /> <agnt_cnta_tlph /> <agnt_nati /> <agnt_brth_date />" +
            "<agnt_addr /> <agnt_id_expi_date /> <note /> <agnt_reas /> <acct_sequ_num /> <auxy_feld /> </ agnt_bsin_info> <canl_load_bsin_info_cnt /> <canl_load_bsin_info> <spcl_bsin_num /> <cust_acct_num /> </canl_load_bsin_info> <data_bfor_modf /> <recp_addl_data /> <pay_vldt_data_cnt /> <pay_vldt_data> <pay_vldt_mask_cod /> <pay_vldt_cod_typ />" +
            "<pay_vldt_cod /> <pay_vldt_cod_num /> </pay_vldt_data> </input_data_area> \",\"_link_hash\":-2295835451353126100,\"_probe_name\":\"demo\",\"_dst_ip\":\"22.5.252.18\",\"_rtt\": 0,\"_src_ip\":\"22.5.253.108\",\"_src_tcp\":\"22.5.253.108:35696\",\"_is_response\":1,\"_ret_code_x\":null,\"_cip\": 369491308,\"_trans_transfer_ms\":0,\"i\":\"AW144OhJGXlEPcTIULJJ\",\"_start_at\": 1569691050,\"_busi_is_success\":-1,\"_dport\":8800,\"_link\":\"22.5.253.108:35696-22.5.252.18:8800\",\"_ret_code\": {\"this_acct_date\":\"20221220\",\"mutp_pag_qury_piec_num\":\"0000\",\"mesg_data_list\":\"\",\"tmnl_num_leng_14\":\" INTERNET\",\"fee_data_out_area_cnt\":\"00\",\"mutp_pag_qury_flg\":\"N\",\"MaxBusinessSum\": 303600,\"mesg_cntt_cnt\":\"01\",\"info_typ\":\"E\",\"recp_data_cnt\":\"00\",\"ClickNum\": 12101,\"tran_cod_cntn_aply_cod\":\"0200611\",\"mutp_qury_prsd_cnt\":\"000000000\",\"intor_tran_cod\":\"0200611 \",\"mesg_id\":\"PMRA888\",\"retn_info_desc\":\"获取交易网点失败! &1,&2,&3\",\"intor_tran_jnal_num\":\"GCMS20221220101707000930mmxnpnruznwy\",\"mesg_typ\":\"0110\",\"tran_l og_num\":\"SC010128416745\",\"rspn_cod\":\"30\",\"tran_mesg_cycl_cnt\":\"00\",\"tran_call_sequ_num\":\"000\",\"bank_ num\":\"001\",\"ApplyNum\": 88753,\"mutp_pag_qury_rcrd_sum\":\"0000\",\"strk_balc_flg\":\"N\",\"nesb_jnal_num\":\"032312398487\"},\"_start_at_ ms\":1569691050.236,\"_sip\":369490962,\"created_at\":1569691068,\"insert_span\":18,\"_start_at_hour\": 436025,\"streams\":[\"5d37fba9e4b0ea34336907af\"],\"filters\":[]}";

    /**
     * Arrays静态方法
     */
    @Test
    public void sortTest() {
        Runtime r = Runtime.getRuntime();
        System.out.println("JVM可以使用的总内存:    " + r.totalMemory());
        System.out.println("JVM可以使用的剩余内存:   " + r.freeMemory());
        Map oneMap = JSONObject.parseObject(mapJson, Map.class);
        int size = 80_0002;
        int time = 1569736974;
        //collators = new Map[size];
        List<Map<String, Object>> maps = Lists.newArrayListWithExpectedSize(size);
        for(int i = 0; i < size; i++) {
            if (!Strings.isNullOrEmpty(oneMap.get("_start_at").toString())) {
                HashMap map = Maps.newHashMap(oneMap);
                map.put("_start_at", time--);
                maps.add(map);
                //collators[i] = map;
            }
        }
        System.out.println();
        System.out.println("JVM可以使用的总内存:    " + r.totalMemory());
        System.out.println("JVM可以使用的剩余内存:   " + r.freeMemory());
        Long startTime = System.currentTimeMillis();
        //Arrays.parallelSort(collators, START_AT_ORDERING);
        //Arrays.sort(collators, START_AT_ORDERING);
        maps.sort(START_AT_ORDERING);
        Long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        //System.out.println(maps.get(0).toString());
        //System.out.println(maps.get(size - 1).toString());
        //System.out.println(collators[0].toString());
        //System.out.println(collators[size - 1].toString());
        //collators = null;
        maps = null;
        System.out.println("JVM可以使用的总内存:    " + r.totalMemory());
        System.out.println("JVM可以使用的剩余内存:   " + r.freeMemory());

        //for(int i = 0; i < size; i++) {
            //System.out.println(collators[i].toString());
        //}
    }

    Ordering<Map<String,Object>> START_AT_ORDERING = new Ordering<Map<String,Object>>() {
        @Override
        public int compare(Map<String,Object> left, Map<String,Object> right) {
            if (left == null || left.get(START_AT) == null) {
                return -1;
            }
            if (right == null || right.get(START_AT) == null) {
                return 1;
            }
            return left.get(START_AT).toString().compareTo(right.get(START_AT).toString());
        }
    };
}

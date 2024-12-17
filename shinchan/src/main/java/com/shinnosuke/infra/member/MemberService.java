package com.shinnosuke.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao MemberDao;
	
	public int selectOneCount(MemberVo memberVo) {
		return MemberDao.selectOneCount(memberVo);
	}
	
	List<MemberDto> selectList(MemberVo memberVo){
		List<MemberDto> members = MemberDao.selectList(memberVo);
			return members;
		}
	
	public int insert(MemberDto memberDto) {
		int result = MemberDao.insert(memberDto);
		return result;
	}
	
	public MemberDto selectOne(MemberDto memberDto) {
		return MemberDao.selectOne(memberDto);
	}
	
//	public MemberDto selectOne(MemberDto memberDto) {
//		MemberDto dto = MemberDao.selectOne(memberDto);
//		return dto;
//	}
	
//	public int update(MemberDto memberDto) {
//		int a = MemberDao.update(memberDto);
//		return a;
//	}
	
	public int update(MemberDto memberDto) {
		return MemberDao.update(memberDto);
	}
	
	public int delete(MemberDto memberDto) {
		return MemberDao.delete(memberDto);
	}
	
	public int uelete(MemberDto memberDto) {
		return MemberDao.uelete(memberDto);
	}
	
	public MemberDto selectOneId(MemberDto memberDto) {
		return MemberDao.selectOneId(memberDto);
	}
	
	public MemberDto selectOneLogin(MemberDto memberDto) {
		return MemberDao.selectOneLogin(memberDto);
	}
	
	public int insertLogLogin(MemberDto memberDto) {
		return MemberDao.insertLogLogin(memberDto);
		
	}
	
	@Value("${kakao.api.key}") // 카카오 API 키를 application.properties에서 가져옵니다
    private String kakaoApiKey;

    // 카카오 메시지 보내기
    public void sendKakaoMessage(String accessToken) {
        String url = "https://kapi.kakao.com/v2/api/talk/memo/default/send";
        
        // 헤더에 Access Token을 추가
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        // 메시지 내용 설정
        String message = "{"
                + "\"object_type\": \"text\","
                + "\"text\": \"카카오 로그인에 성공했습니다! 🎉\","
                + "\"link\": {"
                + "\"web_url\": \"/usr/v1/infra/index/indexUsrView\","
                + "\"mobile_web_url\": \"/usr/v1/infra/index/indexUsrView\""
                + "}"
                + "}";

        // 요청 보내기
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(message, headers);
        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }
	
}

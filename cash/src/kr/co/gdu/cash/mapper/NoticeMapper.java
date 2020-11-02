package kr.co.gdu.cash.mapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import kr.co.gdu.cash.vo.Notice;

@Mapper
public interface NoticeMapper {
	// index화면의 최근 5개 공지를 보여주는 메서드
	List<Notice> selectLatestNoticeList();
}

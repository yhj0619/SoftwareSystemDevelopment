package spring;

public class ChangePasswordService {

	private MemberDao memberDao;

	public void changePassword(String email, String oldPwd, String newPwd) {
		System.out.println("ChangePasswordService#changePassword() 메소드 실행");

		Member member = memberDao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPwd, newPwd);

		memberDao.update(member);
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}

package kr.co.memberservice.domain.entity;


import kr.co.memberservice.domain.dto.MemberMstDto;
import kr.co.memberservice.domain.shared.Address;
import kr.co.memberservice.domain.shared.BaseEntity;
import kr.co.memberservice.domain.shared.Phone;
import kr.co.memberservice.domain.shared.enums.Gender;
import kr.co.memberservice.domain.shared.enums.MemberRank;
import kr.co.memberservice.domain.shared.enums.MemberRole;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_member_mst")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberMstEntity extends BaseEntity {

    @Column(name = "identity", unique = true, nullable = false, length = 100)
    private String identity;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Column(name = "email", unique = true, length = 100)
    private String email;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "birth", nullable = false, length = 100)
    private String birth;
    @Column(name = "refresh_token", length = 600)
    private String refreshToken;

    @Embedded
    private Address address;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "number"
                    , column = @Column(name = "phone", unique = true, nullable = false))
    })
    private Phone phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;
    @Enumerated(EnumType.STRING)
    private MemberRank memberRank;

    @Builder
    public MemberMstEntity(String identity, String password, String name, String birth
            , Phone phone, Gender gender, MemberRole memberRole, MemberRank memberRank) {

        this.identity = identity;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.phone = phone;
        this.gender = gender;
        this.memberRole = memberRole;
        this.memberRank = memberRank;
    }

    public void updateMemberMst(MemberMstDto.UPDATE update){
        //to do...
    }

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }

    public void updatePassword(String password){
        this.password = password;
    }
}

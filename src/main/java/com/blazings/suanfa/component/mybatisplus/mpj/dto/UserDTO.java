package com.blazings.suanfa.component.mybatisplus.mpj.dto;

import com.blazings.suanfa.component.mybatisplus.mpj.entity.User;
import lombok.Data;

@Data
public class UserDTO extends User {
	/** user_address */
	private String tel;
	/** user_address */
	private String address;
	/** user_address */
	private String userAddress;
	/** area */
	private String province;
	/** area */
	private String city;
	/** area */
	private String area;
}

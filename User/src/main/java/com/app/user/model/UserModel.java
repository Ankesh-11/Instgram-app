package com.app.user.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"follower", "following", "followRequests", "notifications"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	private String username;
	private String fullName;
	private String email;
	private String mobile;
	private String bio;
	private String image="https://images.app.goo.gl/Tz8mx3QDqc6rm55w6";
	private String password;

	@Embedded
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Integer> follower = new HashSet<Integer>();

	@Embedded
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Integer> following = new HashSet<Integer>();

	@Embedded
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Integer> followRequests = new HashSet<>();

	@OneToMany(fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Integer> notifications = new ArrayList<>();
}

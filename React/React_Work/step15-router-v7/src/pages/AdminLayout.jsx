import React from "react";
import { Outlet } from "react-router-dom";

function AdminLayout() {
	return (
		<div style={{ backgroundColor: "skyblue" }}>
			<h3>관리자 공통레이아웃</h3>
			<Outlet />
		</div>
	);
}

export default AdminLayout;

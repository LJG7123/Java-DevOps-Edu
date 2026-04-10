import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App.jsx";
import App02 from "./App02";

createRoot(document.getElementById("root")).render(
	<StrictMode>
		{/* <App /> */}
		<App02 />
	</StrictMode>,
);

import {Link, Outlet} from "react-router-dom";
import './Layout.css'
import { useAuth } from "../AuthProvider";
const Layout = () => {
    const {logout} = useAuth()

   return( <div className="Layout">
        <nav>
            <ul>
                <li className="grow">
                    <Link to="/">
                        <button type="button">Home</button>
                    </Link>
                </li>
                <li>
                    <Link to="/">
                        <button type="button" onClick={() => logout()}>Log out</button>
                    </Link>
                </li>
                <li>
                    <Link to="/questions">
                        <button type="button">Questions</button>
                    </Link>
                </li>
                <li>
                    <Link to="/create-question">
                        <button type="button">Ask Question</button>
                    </Link>
                </li>
                <li>
                    <Link to="/users">
                        <button type="button">Users</button>
                    </Link>
                </li>
            </ul>
        </nav>
        <Outlet/>
    </div>
)
};

export default Layout;
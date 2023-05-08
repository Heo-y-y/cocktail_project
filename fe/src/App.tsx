import { ThemeProvider } from "styled-components";
import theme from "./components/style/theme";
import styled from "styled-components";
// import { Routes, Route } from "react-router-dom";
import GlobalStyle from "./components/style/GlobalStyles";
import Header from "./components/header/Header";
// import SideBar from "./components/sideBar/SideBar";
import Footer from "./components/footer/Footer";
// import MainComponent from "./components/main/MainComponent";
// import Signup from "./pages/Signup";
import Cocktailshare from "./pages/Cocktailshare";

const TopContainer = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
`;

function App() {
  return (
    <>
      <GlobalStyle />
      <ThemeProvider theme={theme}>
        <TopContainer>
          {/* <Signup /> */}
          <Header />
          <Cocktailshare />
          <Footer />
        </TopContainer>
      </ThemeProvider>
    </>
  );
}

export default App;

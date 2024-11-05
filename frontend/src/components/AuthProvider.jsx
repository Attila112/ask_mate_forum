import React, { createContext, useState, useContext } from 'react';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [userId, setUserId] = useState("");

  const loginUser = async (user) => {
    const response = await fetch("/api/users/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(user),
    });
    const data = await response.json();
    setUserId(data)
    sessionStorage.setItem('userId', data)
    return data
  };

  const logout = () => {
    sessionStorage.removeItem('userId');
    window.location.reload();
  };

  return (
    <AuthContext.Provider value={{  userId, logout, loginUser }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => useContext(AuthContext);
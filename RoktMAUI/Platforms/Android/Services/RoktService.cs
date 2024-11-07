using System;
using RoktMAUI;
using RoktMAUI.Services;
using static Android.Provider.DocumentsContract;

namespace RoktMAUI.Platforms.Android.Services
{
	public class RoktService: IRoktService
	{
        public void InitializeSDK(string clientKey)
        {
            RoktSDKWrapper.RoktSDkWrapper.InitializeSDK(clientKey, "4.6.0", MainActivity.Instance);
        }
    }
}


using Android.App;
using Android.Content.PM;
using Android.OS;

namespace RoktMAUI;

[Activity(Theme = "@style/Maui.SplashTheme", MainLauncher = true, LaunchMode = LaunchMode.SingleTop, ConfigurationChanges = ConfigChanges.ScreenSize | ConfigChanges.Orientation | ConfigChanges.UiMode | ConfigChanges.ScreenLayout | ConfigChanges.SmallestScreenSize | ConfigChanges.Density)]
public class MainActivity : MauiAppCompatActivity
{
    protected override void OnCreate(Bundle? savedInstanceState)
    {
        base.OnCreate(savedInstanceState);
        try
        {
            RoktSDKWrapper.RoktSDkWrapper.InitializeSDK("222", "4.6.0", this);
            RoktSDKWrapper.RoktSDkWrapper.ToggleLogging(true);
            RoktSDKWrapper.RoktSDkWrapper.ExecuteLayoutTest("ExampleView");
        }
        catch (Exception ex)
        {
            Console.Write(ex);
        }
    }
}


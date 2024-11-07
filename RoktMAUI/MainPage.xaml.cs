using RoktMAUI.Services;
using System.Text;

namespace RoktMAUI;

public partial class MainPage : ContentPage
{

	public MainPage()
	{
		InitializeComponent();
	}

	private void OnCounterClicked(object sender, EventArgs e)
	{
		try
        {
			lblResult.Text = "";
            var roktSDK = ServiceHelper.GetService<IRoktService>();
			roktSDK.InitializeSDK("222");
            lblResult.Text = "Rokt SDK Init Successful";
        }
		catch (Exception ex)
        {
			Console.WriteLine(ex);
			var resultSB = new StringBuilder();
            resultSB.AppendLine($"Rokt Message: {ex.Message}");
            resultSB.AppendLine($"Rokt Source: {ex.Source}");
            resultSB.AppendLine($"Rokt StackTrace: {ex.StackTrace}");
			var displayText = resultSB.ToString();
			lblResult.Text = displayText;
            Console.WriteLine(displayText);
        }
	}
}



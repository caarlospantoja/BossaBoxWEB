import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.internal.Exceptions
import internal.GlobalVariable

import org.junit.Assert
import org.openqa.selenium.Keys
import org.testng.Assert as Keys

try {
	WebUI.delay(5)
	WebUI.openBrowser('')
	WebUI.navigateToUrl(GlobalVariable.BOSSAURL)
	WebUI.maximizeWindow()
	
	//Clicando no link para Cadastro de Novo Usuário
	WebUI.verifyElementVisible(findTestObject('Object Repository/HomePage/Button_CadastreSe'))
	WebUI.click(findTestObject('Object Repository/HomePage/Button_CadastreSe'))
	WebUI.delay(2)
	
	//Cadastrando Novo Usuário
	WebUI.click(findTestObject('Object Repository/CadastroPage/InputField_Nome'))
	WebUI.setText(findTestObject('Object Repository/CadastroPage/InputField_Nome'), "José Carlos Pantoja")
	WebUI.click(findTestObject('Object Repository/CadastroPage/InputField_Email'))
	WebUI.setText(findTestObject('Object Repository/CadastroPage/InputField_Email'), "carlos@bossabox.com")
	WebUI.click(findTestObject('Object Repository/CadastroPage/InputField_Senha'))
	WebUI.setText(findTestObject('Object Repository/CadastroPage/InputField_Senha'), "12345678")
	WebUI.click(findTestObject('Object Repository/CadastroPage/InputField_ConfirmSenha'))
	WebUI.setText(findTestObject('Object Repository/CadastroPage/InputField_ConfirmSenha'), "12345678")
	WebUI.click(findTestObject('Object Repository/CadastroPage/Button_Cadastrar'))
	
	
	//Verificando mensagem de email existente
	
	String getText = WebUI.getText(findTestObject('Object Repository/CadastroPage/TextDisplay_ErrorDisplay'))
	Assert.assertEquals("E-mail já cadastrado!", getText)
	WebUI.closeBrowser();
	
}catch(Exception exp) {
	Assert.fail('Ocorreu um erro durante o teste: '+ exp.getMessage())
}
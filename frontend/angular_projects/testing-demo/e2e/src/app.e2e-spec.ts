import { AppPage } from './app.po';
import { browser, by, element, logging } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it("test render details page",()=>{
    console.log("*******inside testRender");
    browser.get("http://localhost:4200/details");
    let empIdElement=element(by.css("#empId"));
    //empIdElement.getText().then(result=>console.log("***employee id rendered",result));
    expect(empIdElement.getText()).toContain("1");
    let empNameElement=element(by.css("#empName"));
    expect(empNameElement.getText()).toContain("remjith");
    let empAgeElement=element(by.css("#empAge"));
    expect(empAgeElement.getText()).toContain("25");

  })

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
